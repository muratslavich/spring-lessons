package simpleproxy.dynamic;

import lombok.extern.apachecommons.*;
import org.springframework.stereotype.Component;

@CommonsLog
@Component
public class SimpleServiceImpl implements SimpleService {
    @Override
    public void foo() {
        log.info("----> foo()");
        this.bar();
    }

    public void bar() {
        log.info("----> bar()");
    }
}
