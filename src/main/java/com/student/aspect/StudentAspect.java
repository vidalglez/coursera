package com.student.aspect;

import com.student.core.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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

    @Around("log() && args(id)")
    public Object around(ProceedingJoinPoint jp, long id) throws Throwable {
        log.info("Around before -> {} with id {}", jp.getSignature().getName(), id);
        Student student = (Student) jp.proceed();
        log.info("Around after -> {} {}", student.getFirstName(), student.getSurname());
        return student;
    }
}
