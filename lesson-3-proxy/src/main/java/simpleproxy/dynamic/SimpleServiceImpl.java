package simpleproxy.dynamic;

import lombok.extern.apachecommons.*;

@CommonsLog
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
