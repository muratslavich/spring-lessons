## Spring beans

#### Scope бинов

- singleton
- prototype
- request - инстанс на каждый http запрос
- session - инстанс на каждую http сессию
- global-session - инстанс на каждую глобальную http сессию

#### Beans Lifecycle

1. Instantiation
    - invoke the constructor through reflection
    - set bean name
2. Populating properties - dependencies
3. Pre initialization
    - postProcessBeforeInitialization
    - postConstruct
4. After properties set
    - afterPropertiesSet
5. Custom initialization
    - init method
6. Post initialization
    - postProcessAfterInitialization
7. Bean is ready
8. Pre destroy
9. Destroy
10. Custom destruction

#### Иницализация синглтонов
BeanDefinition - рецепты для создания бинов. Определяются в конфигурации.

1. Парсинг конфигурации и создание всех BeanDefinitions
    - AnnotatedBeanDefinitionReader
    - BeanDefinitionReader
    - ClassPathBeanDefinitionScanner
2. Создание кастомных beanFactory
    - FactoryBean<T>
3. Настройка созданных BeanDefinitions
    - BeanFactoryPostProcessor
4. Инстанциирование бинов
    - BeanFactory
5. Настройка созданных бинов
    - BeanPostProcessor

Шаги старта annotation-based контекста:
1. AnnotationConfigApplicationContext.scan()  
    - сканирование пакета и загрузка bean definitions  
2. старт контекста applicationStartup.start  
3. AbstractApplicationContext.prepareRefresh()  (org.springframework.context.support)  
4. AbstractApplicationContext.obtainFreshBeanFactory()  (org.springframework.context.support)  
5. AbstractApplicationContext.prepareBeanFactory(ConfigurableListableBeanFactory)  (org.springframework.context.support)  
    - конфигурирование стандартного factory's контекста -  context's ClassLoader and post-processors, Register default environment beans.  
6. AbstractApplicationContext.postProcessBeanFactory(ConfigurableListableBeanFactory)  (org.springframework.context.support)  
    - изменение beanFactory после стандартной инициализации бинов.  
    - все bean definitions загружены, но не инстанцированны  
    - это позволяет зарегистрировать кастомные BeanPostProcessors  
7. AbstractApplicationContext.invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory)  (org.springframework.context.support)  
    - Instantiate and invoke all registered BeanFactoryPostProcessor beans  
    - вызывается до инстанцирования синглтонов  
8. AbstractApplicationContext.registerBeanPostProcessors(ConfigurableListableBeanFactory)  (org.springframework.context.support)  
    - Instantiate and register all BeanPostProcessor beans  
    - вызывается до инстанцирование любых бинов приложения  
9. beanPostProcess.end()  
10. AbstractApplicationContext.initMessageSource()  (org.springframework.context.support)  
11. AbstractApplicationContext.initApplicationEventMulticaster()  (org.springframework.context.support)  
12. AbstractApplicationContext.onRefresh()  (org.springframework.context.support)  
13. AbstractApplicationContext.registerListeners()  (org.springframework.context.support)  
14. AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory)  (org.springframework.context.support)  
    - инициализация синглтонов тут  
15. AbstractApplicationContext.finishRefresh()  (org.springframework.context.support)  
    - последний шаг - публикация соответствующего евента  


#### Dependency injection
- @Autowired
- Constructor, method
- circular dependency 

#### Prototype in singleton
 
