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
    * Циклическая зависимость может быть разрешена как @Lazy.
    * Вмсето полной инициализации зависимости, будет созданно прокси.
    * Прокси заменится на инициализированный бин после первого обращения.
    * */
    @Test
    public void testLazyInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            circular.lazy.FirstBean.class,
            circular.lazy.SecondBean.class
        );

        circular.lazy.FirstBean bean = context.getBean(circular.lazy.FirstBean.class);
        circular.lazy.SecondBean secondBean = bean.getSecondBean();
    }

    /*
     * Циклическая зависимость может быть разрешена внедрением через setter.
     * */
    @Test
    public void testSetterInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            circular.field.FirstBean.class,
            circular.field.SecondBean.class
        );

        circular.field.FirstBean bean = context.getBean(circular.field.FirstBean.class);
    }

    /*
     * Циклическая зависимость может быть разрешена с помощью @PostConstruct.
     * */
    @Test
    public void testPostConstructInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            circular.post.FirstBean.class,
            circular.post.SecondBean.class
        );

        circular.post.FirstBean bean1 = context.getBean(circular.post.FirstBean.class);
        circular.post.SecondBean bean2 = context.getBean(circular.post.SecondBean.class);
        assertNotNull( bean1.getSecondBean() );
        assertNotNull( bean2.getFirstBean() );
    }

    /*
    * Паттерн Service Factory Lookup.
    * Инжектирование спрингового бина в не спринговый класс.
    * */
    @Test
    public void testServiceFactoryLocator() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceFactoryConfiguration.class);

        ServiceExample serviceExample = ServiceFactoryLocator.getBean(ServiceExample.class);

        assertNotNull(serviceExample);
    }

}
