import simpleproxy.dynamic.*;
import org.junit.jupiter.api.*;
import org.springframework.aop.aspectj.annotation.*;
import simpleproxy.*;

public class SpringAspectJTest {
    @Test
    public void aspectJTest() {
        AspectJProxyFactory factory = new AspectJProxyFactory(new SimpleServiceImpl());

        factory.addAspect(NotVeryUsefulAspect.class);

        SimpleService proxy = factory.getProxy();
        proxy.foo();
    }
}
