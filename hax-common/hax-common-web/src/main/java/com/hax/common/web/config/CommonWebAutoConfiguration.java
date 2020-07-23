package com.hax.common.web.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hax.common.web.handler.GlobalExceptionHandlerResolver;
import com.hax.common.web.handler.GlobalResponseBodyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CommonWebAutoConfiguration implements WebMvcConfigurer {

    // ========== 全局处理器 ==========

//    TODO 记录访问日志 后期加
//    @Bean
//    @ConditionalOnMissingBean(GlobalResponseBodyHandler.class)
//    public GlobalResponseBodyHandler globalResponseBodyHandler() {
//        return new GlobalResponseBodyHandler();
//    }


    @Bean
    @ConditionalOnMissingBean(GlobalExceptionHandlerResolver.class)
    public GlobalExceptionHandlerResolver globalExceptionHandler() {
        return new GlobalExceptionHandlerResolver();
    }

    @Bean
    @ConditionalOnMissingBean(GlobalResponseBodyHandler.class)
        public GlobalResponseBodyHandler globalResponseBodyHandler() {
        return new GlobalResponseBodyHandler();
    }




    // ========== 过滤器相关  ==========
    //跨域处理
    @Bean
    @ConditionalOnMissingBean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        //允许所有域名进行跨域调用
        config.addAllowedOrigin("*");
        //允许跨越发送cookie
        config.setAllowCredentials(true);
        //放行全部原始头信息
        config.addAllowedHeader("*");
        //允许所有请求方法跨域调用
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


    //   ========== MessageConverter 相关 ==========
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建 FastJsonHttpMessageConverter 对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 自定义 FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.defaultCharset()); // 设置字符集
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect); // 剔除循环引用
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        // 设置支持的 MediaType
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // 添加到 converters 中
        converters.add(0, fastJsonHttpMessageConverter); // 注意，添加到最开头，放在 MappingJackson2XmlHttpMessageConverter 前面
    }

}
