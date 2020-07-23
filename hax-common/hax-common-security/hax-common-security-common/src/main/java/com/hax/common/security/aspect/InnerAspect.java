package com.hax.common.security.aspect;


import cn.hutool.core.util.StrUtil;
import com.hax.common.core.enums.SystemConstants;
import com.hax.common.core.exception.GlobalException;
import com.hax.common.core.exception.ServiceException;
import com.hax.common.core.utils.RequestHolder;
import com.hax.common.security.annotations.Inner;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

import static com.hax.common.core.enums.GlobalErrorCodeConstants.FORBIDDEN;

/**
 * 服务间接口不鉴权处理逻辑
 *
 * @author ruoyi
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class InnerAspect implements Ordered {


    @SneakyThrows
    @Around("@annotation(inner)")
    public Object around(ProceedingJoinPoint point, Inner inner) {
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        String header = request.getHeader(SystemConstants.FROM);
        if (inner.value() && !StrUtil.equals(SystemConstants.FROM_IN, header)) {
            log.error("访问接口 {} 没有权限", point.getSignature().getName());
            throw new GlobalException(FORBIDDEN);
        }
        return point.proceed();
    }


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
