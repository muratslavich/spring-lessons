## Spring beans

#### Scope бинов

- singleton
- prototype
- request - инстанс на каждый http запрос
- session - инстанс на каждую http сессию
- global-session - инстанс на каждую глобальную http сессию

Можно создать свой кастомный scope. 

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

#### Dependency injection
- @Autowired
- Constructor, method
- Service Factory Lookup
- circular dependency 

#### Prototype in singleton
 
