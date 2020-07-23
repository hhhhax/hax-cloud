package com.hax.common.mybatis.interceptor.mybatis;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


/**
 * @author hax
 * @Date: 2019-09-30
 * @Description:mybatis通用字段拦截器
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class CommonFieldHandlerInterceptor implements Interceptor {



    public CommonFieldHandlerInterceptor() {
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final static String ANONYMOUS_CREATE_USER = "system";
    private final static String FIELD_CREATE_USER = "createUser";
    private final static String FIELD_CREATE_TIME = "createTime";
    private final static String FIELD_UPDATE_USER = "updateUser";
    private final static String FIELD_UPDATE_TIME = "updateTime";

    @SuppressWarnings({"rawtypes"})
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            System.out.println("进入拦截方法");
        } catch (Exception e) {
            logger.error("通用字段设置值时出错", e);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
