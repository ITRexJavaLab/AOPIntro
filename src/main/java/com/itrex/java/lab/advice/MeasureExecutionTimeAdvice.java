package com.itrex.java.lab.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MeasureExecutionTimeAdvice {

    private static final String METHOD_EXECUTION_TIME_MSG_PATTERN = "method %s execution takes %d millis";

    @Around(value = "@annotation(com.itrex.java.lab.annotation.MeasureExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(String.format(METHOD_EXECUTION_TIME_MSG_PATTERN, joinPoint.getSignature().toLongString(), end - start));

        return result;
    }
}
