package app;

import org.springframework.context.annotation.*;

@Configuration
public class BeanConfiguration {

    @Bean(name = "mySuperBean", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public ServiceExample serviceExample() {
        return new ServiceExample();
    }

}
