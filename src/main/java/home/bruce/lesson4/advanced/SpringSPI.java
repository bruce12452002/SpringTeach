package home.bruce.lesson4.advanced;

import home.bruce.lesson4.advanced.bean.Animal;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Spring SPI 機制： 在 META-INF 放 spring.factories 檔案，格式為「介面=類別, 類別」
 * META-INF/spring.handlers 為讀取 xml 檔轉換成 java
 */
public class SpringSPI {
    public static void main(String[] args) {
        List<Animal> animals =
                SpringFactoriesLoader.loadFactories(Animal.class, Thread.currentThread().getContextClassLoader());
        System.out.println(animals);
    }

    private static void xml() {
        try {
            Properties prop =
                    PropertiesLoaderUtils.loadAllProperties("META-INF/spring.handlers", null);
            System.out.println(prop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
