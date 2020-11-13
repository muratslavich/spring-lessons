import app.beans.*;
import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

import static org.junit.jupiter.api.Assertions.*;

@CommonsLog
public class BeanFactoryXmlConfigurationTest {

    @Test
    public void beanFactoryTest() {
        Resource res = new ClassPathResource("bean-config.xml");
        BeanFactory beanFactory = new XmlBeanFactory(res);

        assertNotNull( beanFactory.getBean(Thing.class) );
        assertNotNull( beanFactory.getBean(OtherThing.class) );
        assertTrue( beanFactory.getBean("thing") instanceof Thing );

        assertTrue( beanFactory.isTypeMatch("thing", Thing.class) );
        assertTrue( beanFactory.isSingleton("thing") );
        assertFalse( beanFactory.isPrototype("thing") );
    }

    @Test
    public void beanFactoryLazyInitializationTest() {
        Resource res = new ClassPathResource("lazy-bean-factory.xml");
        BeanFactory beanFactory = new XmlBeanFactory(res);

        assertFalse( LazyBean.isBeanInstantiated );

        assertNotNull( beanFactory.getBean(LazyBean.class) );

        assertTrue( LazyBean.isBeanInstantiated );
    }

}
