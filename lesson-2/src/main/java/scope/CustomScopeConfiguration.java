package scope;

import app.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomScopeConfiguration {

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new ServiceExampleBeanPostProcessor();
    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomScopeBeanFactoryPostProcessor();
    }

    @Bean
    @Scope(scopeName = "tenant")
    public ServiceExample serviceExample() {
        return new ServiceExample();
    }

}
