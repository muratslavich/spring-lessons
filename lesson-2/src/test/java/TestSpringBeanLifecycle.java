import app.configuration.*;
import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import app.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@CommonsLog
public class TestSpringBeanLifecycle {

    /*
    * Пример жизненного цикла синглтона.
    * Пример использования BeanPostProcessor
    * */
    @Test
    public void testSingleton() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(SingletonConfiguration.class);

        ServiceExample singleton1 = context.getBean(ServiceExample.class);
        ServiceExample singleton2 = context.getBean(ServiceExample.class);

        assertEquals(singleton1, singleton2);

        context.removeBeanDefinition("mySuperBean");
        context.close();
    }

    /*
    * Пример использования prototype бина
    * */
    @Test
    public void testPrototype() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeConfiguration.class);

        ServiceExample prototype1 = context.getBean(ServiceExample.class);
        ServiceExample prototype2 = context.getBean(ServiceExample.class);

        assertNotEquals(prototype1, prototype2);

        context.removeBeanDefinition("mySuperBean");
        context.close();
    }

}
