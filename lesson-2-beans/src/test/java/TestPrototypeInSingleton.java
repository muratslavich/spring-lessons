import injections.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestPrototypeInSingleton {
    /*
     * Если прототип является зависимостью синглтона,
     * он будет создан в момент настройки синглтона и не будет изменяться.
     * */
    @Test
    public void testPrototypeInSingleton() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            BeanA.class,
            PrototypeBean.class
        );

        assertTrue( context.getBeanDefinition("beanB").isPrototype() );

        BeanA singleton = context.getBean(BeanA.class);
        assertEquals(
            singleton.getBeanB(),
            singleton.getBeanB()
        );
    }


    /*
     * Тоже самое для инъекции через сеттер. Прототип будет создан во время конфигурации синглтона.
     * */
    @Test
    public void testPrototypeInSingletonSetterInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            PrototypeBean.class,
            MethodInjectionBean.class
        );

        assertTrue( context.getBeanDefinition("beanB").isPrototype() );

        MethodInjectionBean singleton = context.getBean(MethodInjectionBean.class);
        assertEquals(
            singleton.getPrototype(),
            singleton.getPrototype()
        );
    }

    /*
     * Чтобы получать каждый раз новый объект бина prototype из синглтона,
     * можно воспользоваться аннотцией @Lookup над методом возращающим прототип.
     * */
    @Test
    public void testPrototypeInSingletonLookup() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            PrototypeBean.class,
            LookupBean.class
        );

        assertTrue( context.getBeanDefinition("beanB").isPrototype() );

        LookupBean singleton = context.getBean(LookupBean.class);
        assertNotEquals(
            singleton.getPrototype(),
            singleton.getPrototype()
        );

        singleton.getPrototype();
        singleton.getPrototype();
    }

    /*
     * Мы можем инжектировать весь контекст в наш синглтон, и доставать каждый раз новый прототип.
     * Но это плохое решение и оно ни чем не отличается от SFL.
     * */
    @Test
    public void testPrototypeInSingletonApplicationContextAware() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            PrototypeBean.class,
            ApplicationContextAwareSingletonBean.class
        );

        assertTrue( context.getBeanDefinition("beanB").isPrototype() );

        ApplicationContextAwareSingletonBean singleton = context.getBean(ApplicationContextAwareSingletonBean.class);
        assertNotEquals(
            singleton.getPrototype(),
            singleton.getPrototype()
        );
    }

    /*
     * Используя javax.inject Provider.
     * */
    @Test
    public void testPrototypeInSingletonProvider() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            PrototypeBean.class,
            ProviderBean.class
        );

        assertTrue( context.getBeanDefinition("beanB").isPrototype() );

        ProviderBean singleton = context.getBean(ProviderBean.class);
        assertNotEquals(
            singleton.getPrototypeInstance(),
            singleton.getPrototypeInstance()
        );
    }
}
