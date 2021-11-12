package com.itrex.java.lab.advice;

import java.util.Random;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WaitTimeAdvice {

    private static final int MIN = 1000;
    private static final int MAX = 9000;
    private static final Random RANDOM = new Random();

    @Around(value = "execution(* waitSomeTime(Integer))")
    public Object fixWaitTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Integer waitTime = (Integer) joinPoint.getArgs()[0];
        if (waitTime == null || waitTime < MIN || waitTime > MAX) {
            waitTime = RANDOM.nextInt(MAX - MIN + 1) + MIN;
        }

        return joinPoint.proceed(new Object[]{waitTime});
    }
}
