import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import simpleproxy.dynamic.*;

import java.lang.reflect.*;

@CommonsLog
public class DynamicProxyTest {

    @Test
    public void foo() {
        SimpleService instance = (SimpleService) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class[]{ SimpleService.class },
            ((proxy, method, args) -> {
                log.info("---> ADvice " + method.getName());
                return method.invoke(new SimpleServiceImpl(), args);
            })
        );

        instance.foo();
    }

}
