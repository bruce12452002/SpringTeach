package home.bruce.lesson6;

import home.bruce.lesson6.service.MyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan("home.bruce.lesson6")
@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FullAnnotationImpl {
    @Pointcut("execution(void home.bruce.lesson6.service.MyService.display2(*))")
    public void common() {
    }

    @Before("common()")
    public void before() {
        System.out.println("anno-MyAopImpl-before");
    }

    @After("execution(void home.bruce.lesson6.service.MyService.display2(..))")
    public void after() {
        System.out.println("anno-MyAopImpl-after");
    }

    /**
     * 可以不用參數，但要參數，可如下三種
     * JoinPoint：任何通知都可以用，可取得目標物件、方法、參數
     * ProceedingJoinPoint：使用 proceed 方法，執行目標的方法
     * Throwable：使用在例外通知
     */
    @Around("common()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("anno-環前");
        Object proceed = joinPoint.proceed();
        System.out.println("anno-環後");
        return proceed;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FullAnnotationImpl.class);
        MyService ms = context.getBean(MyService.class);
        ms.display2("");
    }
}
