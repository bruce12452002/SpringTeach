package home.bruce.lesson5;

import home.bruce.lesson5.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/aop_config.xml");
        MyService ms = context.getBean(MyService.class); // 不可寫 MyServiceImpl.class，因為已被代理
//        context.getBean("myServiceImpl", Proxy.class); // 用 Proxy 來接，但沒什麼方法可用
        ms.display2("");
    }
}
