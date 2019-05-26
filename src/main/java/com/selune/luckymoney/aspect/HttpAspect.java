package com.selune.luckymoney.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Selune
 * @Date: 5/26/19 4:42 PM
 */

@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Pointcut("execution(public * com.selune.luckymoney.controller.LuckymoneyController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        log.info("url= {}", request.getRequestURL());
        // method
        log.info("method= {}", request.getMethod());
        // ip
        log.info("ip= {}", request.getRemoteAddr());
        // class_method
        log.info("class_method= {}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // args
        log.info("args= {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("doAfter");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response= {}", object);
    }
}
