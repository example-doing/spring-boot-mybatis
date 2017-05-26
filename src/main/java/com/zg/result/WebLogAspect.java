package com.zg.result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<HttpLog> log = new ThreadLocal<>();

    @Pointcut("execution(public * com.zg.web..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        HttpLog httplog = new HttpLog(request.getRemoteAddr(), request.getMethod(), request.getRequestURL().toString(), classMethod);


        log.set(httplog);
    }

    @AfterReturning(returning = "o", pointcut = "webLog()")
    public void doAfterReturning(Object o) throws Throwable {
        HttpLog httplog = log.get();
        if (httplog != null) {
            ResponseView s = (ResponseView) o;
            httplog.setCode(s.getCode());
            logger.info(httplog.toString());
        } else {
            logger.warn("something error");
        }
    }
}
