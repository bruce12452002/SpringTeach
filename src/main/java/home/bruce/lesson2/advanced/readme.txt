每個 bean tag 是一個 BeanDefinition
Spring 會將所有 BeanDefinition 放到一個 BeanDefinitionMap
最後再放到 singletonObjects 裡，之後 getBean 時，就是到這裡去拿來用的