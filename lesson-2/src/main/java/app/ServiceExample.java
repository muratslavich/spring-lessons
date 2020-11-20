package app;

import lombok.extern.apachecommons.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.*;
import org.springframework.context.*;

import javax.annotation.*;

@CommonsLog
public class ServiceExample implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public ServiceExample() {
        log.info("----> here constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("----> here after properties set");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("----> here post construct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("----> here pre destroy");
    }

    // should be defined directly in @Configuration
    private void initMethod() {
        log.info("----> here init");
    }

    private void destroyMethod() {
        log.info("----> here destroy method");
    }

    @Override
    public void setBeanName(String name) {
        log.info("----> here set bean name " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("----> here set application context");
    }

    @Override
    public void destroy() throws Exception {
        log.info("----> here destroy");
    }

}
