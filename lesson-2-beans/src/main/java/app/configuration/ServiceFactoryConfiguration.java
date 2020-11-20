package app.configuration;

import app.*;
import org.springframework.context.annotation.*;

@Configuration
public class ServiceFactoryConfiguration {

    @Bean(name = "mySuperBean", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public ServiceExample serviceExample() {
        return new ServiceExample();
    }

    @Bean
    public ServiceFactoryLocator serviceFactoryLocator() {
        return new ServiceFactoryLocator();
    }

}
