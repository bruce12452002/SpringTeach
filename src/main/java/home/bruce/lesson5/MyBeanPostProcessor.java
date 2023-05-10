package home.bruce.lesson5;

import home.bruce.lesson5.bean.MyAop;
import home.bruce.lesson5.bean.MyAopImpl;
import home.bruce.lesson5.service.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("home.bruce.lesson5")
public class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("home.bruce.lesson5.service".equals(bean.getClass().getPackageName())) {
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (obj, method, objArr) -> {
                        MyAop myAop = applicationContext.getBean(MyAopImpl.class);
                        myAop.before();
                        Object result = method.invoke(bean, objArr);
                        myAop.after();
                        return result;
                    }
            );
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanPostProcessor.class);
        // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        MyService ms = context.getBean(MyService.class); // 不可寫 MyServiceImpl.class，因為已被代理
        // context.getBean("myServiceImpl", Proxy.class); // 用 Proxy 來接，但沒什麼方法可用
        ms.display();

    }
}
