Spring 生命週期：
每個 bean tag 是一個 BeanDefinition
Spring 會將所有 BeanDefinition 放到一個 beanDefinitionMap 裡
最後再放到 singletonObjects 裡，之後 getBean 時，就是到這裡去拿來用的

但在放到 singletonObjects 之前，還有 BeanFactoryPostProcessor，可以針對已經注入的 bean 修改或新增 bean
BeanFactoryPostProcessor 完後，還有 XxxAware，可以取得某些物件，如取得 bean 名稱、取得 bean 工廠…等
最後還可以針對屬性賦值，使用 BeanPostProcessor，BeanPostProcessor 可在 new 物件前和後做賦值的動作