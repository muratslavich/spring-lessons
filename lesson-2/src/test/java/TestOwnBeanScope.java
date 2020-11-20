import app.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;
import scope.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOwnBeanScope {

    /*
    * Пример добавления кастомного скоупа бинов
    * Пример использования BeanFactoryPostProcessor
    * */
    @Test
    public void testOwnBeanScope() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomScopeConfiguration.class);

        ServiceExample bean = context.getBean(ServiceExample.class);

        assertEquals("tenant", context.getBeanDefinition("serviceExample").getScope());
    }

}
