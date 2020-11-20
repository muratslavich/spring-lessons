import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import app.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@CommonsLog
public class TestSpringBeanLifecycle {

    @Test
    public void logSingletonLifecycle() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext("app");
        context.removeBeanDefinition("mySuperBean");
        context.close();
    }

    @Test
    public void logPrototype() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeConfiguration.class);

        ServiceExample prototype1 = context.getBean(ServiceExample.class);
        ServiceExample prototype2 = context.getBean(ServiceExample.class);

        assertNotEquals(prototype1, prototype2);

        context.close();
    }

}
