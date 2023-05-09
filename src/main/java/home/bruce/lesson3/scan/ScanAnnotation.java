package home.bruce.lesson3.scan;

import home.bruce.lesson3.scan.sub.SubA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.*;

public class ScanAnnotation implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ScanAnnotation.injection("src/main/java/home/bruce/lesson3/scan", registry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("scan.xml");
        System.out.println(context.getBean("Aaa", Aaa.class));
        System.out.println(context.getBean("SubA", SubA.class));
    }

    private static void injection(String path, BeanDefinitionRegistry registry) {
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(path))) {
            for (Path p : ds) {
                if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                    injection(p.toString(), registry);
                } else if (Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS)) {
                    if (p.getFileName().toString().endsWith(".java")) {
//                        System.out.println("file=" + p.getFileName());
                        String[] split = p.toAbsolutePath().toString().split("src/main/java/");
                        String javaPath = split[1].replace("/", ".");
                        int dot = javaPath.lastIndexOf(".");
                        final String packageDotClassName = javaPath.substring(0, dot);

                        // 注入
                        Class<?> clazz = Class.forName(packageDotClassName);
                        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
                            BeanDefinition root = new RootBeanDefinition();
                            root.setBeanClassName(packageDotClassName);
                            registry.registerBeanDefinition(clazz.getSimpleName(), root);
                        }
                    }
                }
            }
        } catch (IOException | DirectoryIteratorException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
