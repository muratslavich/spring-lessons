import annotationproxy.*;
import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.aop.*;
import org.springframework.aop.aspectj.annotation.*;
import org.springframework.aop.framework.*;
import simpleproxy.cglib.*;
import simpleproxy.dynamic.*;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@CommonsLog
public class SpringProxyFactoryTest {

    /*
    * Проксирование класса.
    * Jdk dynamic proxy
    * Метод foo() будет вызван на объекте прокси и к нему будут применены все advice.
    * Однако к вызовам методов внутри оригинального класса this.bar() advice не будут применены.
    * */
    @Test
    public void dynamicProxyTest() {
        ProxyFactory factory = new ProxyFactory(new SimpleServiceImpl());
        factory.addInterface(SimpleService.class);
        factory.addAdvice((MethodBeforeAdvice) (method, args, target) -> log.info("----> before " + method.getName()));

        SimpleService proxy = (SimpleService) factory.getProxy();
        proxy.foo();

        assertTrue(factory.getProxy() instanceof Proxy); // JdkDynamicAopProxy
    }

    /*
    * Cglib proxy.
    * Advice все равно не будет вызван для внутреннего this.bar()
    * */
    @Test
    public void cglibProxyTest() {
        ProxyFactory factory = new ProxyFactory(new CglibSimpleService());
        factory.addAdvice((MethodBeforeAdvice) (method, args, target) -> log.info("----> before " + method.getName()));

        CglibSimpleService proxy = (CglibSimpleService) factory.getProxy();
        proxy.foo();
    }

    @Test
    public void aspectJTest() {
        AspectJProxyFactory factory = new AspectJProxyFactory(new SuspectedServiceImpl());
        factory.addInterface(SuspectedService.class);

        factory.addAspect(new AspectionalAdvice());

        SuspectedService proxy = factory.getProxy();
        proxy.foo();
    }

}
