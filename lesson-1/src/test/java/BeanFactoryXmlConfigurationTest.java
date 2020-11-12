import app.beans.*;
import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.*;
import org.springframework.context.support.*;

import static org.junit.jupiter.api.Assertions.*;

@CommonsLog
public class BeanFactoryXmlConfigurationTest {

    @Test
    public void beanFactoryTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-config.xml");

        assertNotNull( beanFactory.getBean(Thing.class) );
        assertNotNull( beanFactory.getBean(OtherThing.class) );
        assertTrue( beanFactory.getBean("thing") instanceof Thing );

        assertTrue( beanFactory.isTypeMatch("thing", Thing.class) );
        assertTrue( beanFactory.isSingleton("thing") );
        assertFalse( beanFactory.isPrototype("thing") );
    }

}
