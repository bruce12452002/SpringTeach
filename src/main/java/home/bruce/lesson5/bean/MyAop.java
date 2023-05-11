package home.bruce.lesson5.bean;

import org.aspectj.lang.ProceedingJoinPoint;

public interface MyAop {
    void before();

    void after();

    Object around(ProceedingJoinPoint joinPoint) throws Throwable;
}
