package com.student.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.inject.Named;

@Named
@Aspect
@Slf4j
public class StudentAspect {

    @Pointcut("execution(* com.student.service.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void before(JoinPoint jp){
        log.info("Invoke Method Before -> {}", jp.getSignature().getName());
    }

    @After("log()")
    public void after(JoinPoint jp){
        log.info("Invoke Method After -> {}", jp.getSignature().getName());
    }
}
