package app;

import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.*;

@Configuration
public class PrototypeConfiguration {

    @Bean(name = "muSuperPrototype", initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ServiceExample prototypeService() {
        return new ServiceExample();
    }

}
