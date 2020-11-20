package app;

import lombok.extern.apachecommons.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.stereotype.*;

@CommonsLog
@Component
public class ServiceExampleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ServiceExample) {
            log.info("----> here postProcessBeforeInitialization " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ServiceExample) {
            log.info("----> here postProcessAfterInitialization " + beanName);
        }
        return bean;
    }
}
