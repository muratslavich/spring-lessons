import app.beans.annotation.*;
import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@CommonsLog
public class ApplicationContextConfigurationTest {

    @Test
    public void xmlApplicationContextTest() {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("bean-config.xml");
        ApplicationContext annotationContext = new ClassPathXmlApplicationContext("annotation-based-config.xml");
        ApplicationContext javaContext = new AnnotationConfigApplicationContext("app.config");

        AnnotationComponent bean = annotationContext.getBean(AnnotationComponent.class);
        assertNotNull( bean.getService() );

        log.info("xml context -> " + Arrays.toString( xmlContext.getBeanDefinitionNames() ));
        log.info("Annotation context -> " + Arrays.toString( annotationContext.getBeanDefinitionNames() ));
        log.info("Java context -> " + Arrays.toString( javaContext.getBeanDefinitionNames() ));
    }

    @Test
    public void applicationContextEventHandlingTest() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("app.events");
        context.start();

        log.info("Java context -> " + Arrays.toString( context.getBeanDefinitionNames() ));
        assertTrue( context.isActive() );

        context.stop();
        context.close();
    }

}
