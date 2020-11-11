import model.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

        Thing test = context.getBean(Thing.class);
        System.out.println(test);
    }
}
