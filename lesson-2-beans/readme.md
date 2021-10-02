## Spring beans

#### Scope бинов

- singleton
- prototype
- request - инстанс на каждый http запрос
- session - инстанс на каждую http сессию
- global-session - инстанс на каждую глобальную http сессию

> Можно создать свой кастомный scope.  
> Implement interface Scope and register related BeanFactoryPostProcessor 

#### Beans Lifecycle

1. Instantiation
    - invoke the constructor through reflection
    - set bean name
2. Populating properties - dependencies
3. Pre initialization
    - `postProcessBeforeInitialization`
    - `postConstruct`
4. After properties set
    - `afterPropertiesSet`
5. Custom initialization
    - `initMethod`
6. Post initialization
    - `postProcessAfterInitialization`
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
2. Настройка созданных BeanDefinitions
    - BeanFactoryPostProcessor
3. Создание кастомных FactoryBean
    - FactoryBean<T>
4. Инстанциирование бинов
    - BeanFactory
5. Настройка созданных бинов
    - BeanPostProcessor



#### Dependency injection
- Field - @Autowired 
    - AutowiredAnnotationBeanPostProcessor
    - внедрение в поле через рефлекшн
```java
ReflectionUtils.makeAccessible(field);
field.set(bean, value);
```
> Минусы
> - нельзя создать immutable объект
> - high coupling with DI container, объекты невозможно использовать вне
> - нельзя инстанцировать класс без рефлекшн, например в тестах

- Constructor 
- Setter
- Service Factory Lookup
- Circular dependency - можно разрешить через
    - @Autowired
    - Setter injection
    - @Lazy
    - @PostConstruct 
