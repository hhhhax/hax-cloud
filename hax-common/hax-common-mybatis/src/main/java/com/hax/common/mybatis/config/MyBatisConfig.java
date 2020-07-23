package com.hax.common.mybatis.config;

import com.hax.common.mybatis.interceptor.mybatis.CommonFieldHandlerInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MyBatis配置类
 * Created by hax on 2019/4/8.
 */
@Configuration(proxyBeanMethods = false)
@EnableTransactionManagement
@MapperScan({"com.hax.*.mapper","com.hax.*.mapperExtend","com.hax.*.demo.mapper","com.hax.*.demo.mapperExtend"})
//@MapperScan({"com.hax.*.mapper","com.hax.*.mapperExtend","com.hax.*.demo.mapper"})
//@org.mybatis.spring.annotation.MapperScan({"com.yoe.app.mapper.**"})
public class MyBatisConfig {

    @Bean
    public Interceptor getInterceptor(){
        return new CommonFieldHandlerInterceptor();
    }
}
