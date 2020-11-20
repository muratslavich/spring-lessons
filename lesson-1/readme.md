## Пример инициализации Spring контекста

### Создание каркаса приложения 
- Gradle
```groovy
plugins {
    id 'java'
    id 'application'
    id "io.freefair.lombok" version "5.3.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.springframework:spring-context:5.3.1'

    // testing
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.3.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.3.1'
}
```

- Maven
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mycompany.app</groupId>
    <artifactId>lesson-1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>11</maven.compiler.release>
        <org.springframework.version>5.3.1</org.springframework.version>
        <org.junit.version>5.3.1</org.junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${org.springframework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${org.junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### Работа с контекстом

Пакеты `org.springframework.app.beans` и `org.springframework.context` являются основными для Spring Framework IoC контейнера.
- Интерфейс `BeanFactory`
    - lazy bean initialization
    - основной интерфейс для взаимодействия с бинами
    - заботится о жизненном цикле бина
    - нужно вручную зарегестрировать `BeanPostProcessor` и `BeanFactoryPostProcessor`
    - не поддерживает annotation-based injection
    - `getBean()` , `containsBean()` , `isSingleton()` , `isPrototype()`
- `ApplicationContext` наследует `BeanFactory`.
    - initialize all beans at startup 
    - Производит автоматическую регистрацию `BeanPostProcessor` и `BeanFactoryPostProcessor`
    - Интеграция с spring AOP фичами
    - Публикует связанные с контекстом events
    - Поддерживает специфические контексты приложений: e.g. `WebApplicationContext`
    - `getBeanDefinitionNames()`
    
Конфигурации
- Xml-based - `ClassPathXmlApplicationContext`
- Annotation-based - `AnnotationConfigApplicationContext(config.xml)` - в xml добавить `component-scan`
    - `@Configuration`
    - `@Component`
    - `@Controller`
    - `@Service`
    - `@Repository`
    - `@Authowired`
    - `@Qualifier`
- Java-config - `AnnotationConfigApplicationContext(basePackage)` - `@Configuration` и `@ComponentScan`

### Шаги старта annotation-based контекста:
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