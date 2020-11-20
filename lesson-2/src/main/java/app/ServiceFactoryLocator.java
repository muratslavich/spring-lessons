package app;

import org.springframework.beans.*;
import org.springframework.context.*;

public class ServiceFactoryLocator implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static <T extends Object> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ServiceFactoryLocator.applicationContext = applicationContext;
    }
}
