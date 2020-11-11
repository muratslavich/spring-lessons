Пример инициализации Spring контекста

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

Пакеты `org.springframework.beans` и `org.springframework.context` являются основными для Spring Framework IoC контейнера.
- Интерфейс `BeanFactory`
    - основной интерфейс для взаимодействия с бинами
    - заботится о жизненном цикле бина
    - нужно вручную зарегестрировать `BeanPostProcessor` и `BeanFactoryPostProcessor`
    - `getBean()` , `containsBean()` , `isSingleton()` , `isPrototype()`
- `ApplicationContext` наследует `BeanFactory`. 
    - Производит автоматическую регистрацию `BeanPostProcessor` и `BeanFactoryPostProcessor`
    - Интеграция с spring AOP фичами
    - Публикует связанные с контекстом events
    - Поддерживает специфические контексты приложений: e.g. `WebApplicationContext`
    
    
