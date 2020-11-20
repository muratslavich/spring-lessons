import app.*;
import app.configuration.*;
import circular.*;
import circular.auto.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBeanInjection {

    /*
    * Инжектирование бинов через конструктор.
    * Пример циклической зависимости FirstBean -> SecondBean -> FirstBean
    * */
    @Test
    public void testCircularDependency() {
        assertThrows(
            UnsatisfiedDependencyException.class,
            () -> new AnnotationConfigApplicationContext(CircularDependencyConfiguration.class)
        );
    }
    /*
    * Инжектирование бинов через @Autowired.
    * Пример циклической FirstBean -> SecondBean -> FirstBean зависимости,
    * разрешенной с помощью @Autowired
    * */
    @Test
    public void testAutowiredInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredBeansConfiguration.class);

        assertNotNull( context.getBean(FirstBean.class) );
        assertNotNull( context.getBean(SecondBean.class) );
    }

    /*
    * Паттерн Bean Lookup.
    * Инжектирование спрингового бина в не спринговый класс.
    * */
    @Test
    public void testServiceFactoryLocator() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceFactoryConfiguration.class);

        ServiceExample serviceExample = ServiceFactoryLocator.getBean(ServiceExample.class);

        assertNotNull(serviceExample);
    }


}
