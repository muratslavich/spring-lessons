import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringProxyingMechanismTest {

    @Test
    public void foo() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("simpleproxy/cglib");
    }

    @Test
    public void bar() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("simpleproxy/dynamic");
    }

}
