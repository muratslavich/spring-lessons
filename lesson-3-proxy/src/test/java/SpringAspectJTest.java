import annotationproxy.*;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

public class SpringAspectJTest {

    @Test
    public void foo() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectjConfig.class);

        SuspectedService bean = context.getBean(SuspectedService.class);

        bean.foo();
    }

}
