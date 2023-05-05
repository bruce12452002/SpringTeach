package home.bruce.lesson2.advanced;

import home.bruce.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory 被調用了");

        // 將 Pig 修改成 Dragon，此類別也必需注入
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("p");
        beanDefinition.setBeanClassName("home.bruce.bean.Dragon");

        // 將 Dog 動態注入到容器
        BeanDefinition root = new RootBeanDefinition();
        root.setBeanClassName("home.bruce.bean.Dog");
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.registerBeanDefinition("d", root);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryPostProcessor.xml");
        System.out.println(context.getBean("p"));
        System.out.println(context.getBean("d"));
        System.out.println(context.getBean(Dog.class));
    }
}
