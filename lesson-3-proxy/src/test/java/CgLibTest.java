import lombok.extern.apachecommons.*;
import org.junit.jupiter.api.*;
import org.springframework.cglib.proxy.*;
import simpleproxy.cglib.*;

@CommonsLog
public class CgLibTest {

    @Test
    public void foo() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibSimpleService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            log.info("----> before " + method.getName());
            return proxy.invokeSuper(obj, args);
        });
        CglibSimpleService service = (CglibSimpleService) enhancer.create();

        service.foo();
    }

}
