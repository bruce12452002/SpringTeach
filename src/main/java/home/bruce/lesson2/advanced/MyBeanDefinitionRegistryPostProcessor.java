package home.bruce.lesson2.advanced;

import home.bruce.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition root = new RootBeanDefinition();
        root.setBeanClassName("home.bruce.bean.Dog");
        registry.registerBeanDefinition("d", root);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("yeah");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("postBeanRegistry.xml");
        System.out.println(context.getBean("p"));
        System.out.println(context.getBean("d"));
        System.out.println(context.getBean(Dog.class));
    }
}
