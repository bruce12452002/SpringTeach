package home.bruce.lesson5.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAopImpl implements MyAop {
    @Override
    public void before() {
        System.out.println("MyAopImpl-before");
    }

    @Override
    public void after() {
        System.out.println("MyAopImpl-after");
    }

    /**
     * 可以不用參數，但要參數，可如下三種
     * JoinPoint：任何通知都可以用，可取得目標物件、方法、參數
     * ProceedingJoinPoint：使用 proceed 方法，執行目標的方法
     * Throwable：使用在例外通知
     */
    @Override
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("環前");
        Object proceed = joinPoint.proceed();
        System.out.println("環後");
        return proceed;
    }
}
