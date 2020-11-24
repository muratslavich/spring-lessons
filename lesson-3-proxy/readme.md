### Proxying Mechanism

- Jdk dynamic proxy
- CGLIB

> If object to be proxied implements at least one interface - Jdk dynamic proxy will be used  

Прокси - паттерн, позволяющией заменить реальные объекты на объекты-прокси. Прокси перехватывают вызов к оригинальному объекту, позволяя сделать что-то до и после вызова.


#### Self-invocation problem.  
Используя прокси, на внутренний вызов не будет применен advice, который определен для прокси.

```java

ublic class SimplePojo implements Pojo {

    public void foo() {
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
    }

    public void bar() {
        // some logic...
    }
}

```

> `@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)`  
To force the use of CGLIB proxies in bean DI.
>Spring will create a proxy to be injected as a dependency, and instantiate the target bean when it is needed.

> `@EnableAspectJAutoProxy(proxyTargetClass = true)`  
To force the use of CGLIB proxies set the value of the proxy-target-class attribute of the <aop:config> element to true


Использование проксирования в spring:
- AOP -> AspectJ
- @Transactional
- @Scheduled
- In Java configuration bean definition
- Spring Security @PreAuthorize
- @Configurable autowiring
 