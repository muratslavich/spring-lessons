package injections;

import org.springframework.beans.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@Component
public class ApplicationContextAwareSingletonBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public PrototypeBean getPrototype() {
        return applicationContext.getBean(PrototypeBean.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
