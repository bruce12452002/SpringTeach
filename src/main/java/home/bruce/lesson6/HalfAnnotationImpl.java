package home.bruce.lesson6;

import home.bruce.lesson6.service.MyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HalfAnnotationImpl {
    @Pointcut("execution(void home.bruce.lesson6.service.MyService.display())")
    public void common() {
    }

    @Before("common()")
    public void before() {
        System.out.println("anno-MyAopImpl-before");
    }

    @After("execution(void home.bruce.lesson6.service.MyService.display())")
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
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/aop_annotation_config.xml");
        MyService ms = context.getBean(MyService.class);
        ms.display();
    }
}
