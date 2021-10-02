package simpleproxy.cglib;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@CommonsLog
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CglibSimpleService {
    public void foo() {
        log.info("----> foo()");
        this.bar();
    }

    public void bar() {
        log.info("----> bar()");
    }
}
