package app.configuration;

import app.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;

@Configuration
public class SingletonConfiguration {

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new ServiceExampleBeanPostProcessor();
    }

    @Bean(name = "mySuperBean", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public ServiceExample serviceExample() {
        return new ServiceExample();
    }

}
