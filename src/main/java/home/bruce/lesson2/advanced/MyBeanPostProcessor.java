package home.bruce.lesson2.advanced;

import home.bruce.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 可以針對屬性賦值
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + beanName);
        if (bean instanceof Dog d) {
            d.setAge(999);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + beanName);
        if (bean instanceof Dog d) {
            d.setAge(888);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanPostProcessor.xml");
        Dog d = context.getBean("d", Dog.class);
        System.out.println(d.getAge());
    }
}
