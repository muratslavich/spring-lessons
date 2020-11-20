package scope;

import lombok.extern.apachecommons.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;

@CommonsLog
public class CustomScopeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /*
    * Register custom scope through the registerScope method on a ConfigurableBeanFactory instance.
    * void registerScope(String scopeName, Scope scope);
    * scopeName, is used to identify/specify a scope by its unique name.
    * scope, is an actual instance of the custom Scope implementation that you wish to register and use.
    * */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("----> here postProcessBeanFactory");
        beanFactory.registerScope("tenant", new CustomBeanScope());
    }

}
