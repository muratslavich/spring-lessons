import model.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

        Thing test = context.getBean(Thing.class);
        System.out.println(test);

        OtherThing byName = (OtherThing) context.getBean("other_thing");
        System.out.println(byName);

        List<String> beanDefinitionNames = List.of( context.getBeanDefinitionNames() );
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
