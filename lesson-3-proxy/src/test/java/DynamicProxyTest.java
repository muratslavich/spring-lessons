import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import simpleproxy.dynamic.*;

import java.lang.reflect.*;

@CommonsLog
public class DynamicProxyTest {

    @Test
    public void foo() {
        SimpleService instance = (SimpleService) Proxy.newProxyInstance(
            getClass().getClassLoader(),                // classLoader
            new Class[]{ SimpleService.class },         // interfaces
            ((proxy, method, args) -> {                 // InvocationHandler
                log.info("---> ADvice " + method.getName());
                return method.invoke(new SimpleServiceImpl(), args);
            })
        );

        instance.foo();
    }

}
