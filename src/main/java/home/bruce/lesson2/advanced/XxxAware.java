package home.bruce.lesson2.advanced;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 可感知某些功能，只要實作某個 Aware，就能使用
 */
public class XxxAware implements ApplicationContextAware, BeanFactoryAware, BeanNameAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory=" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName=" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 調用到 AbstractApplicationContext 的 toString()
        System.out.println("setApplicationContext=" + applicationContext);
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("aware.xml");
    }
}
