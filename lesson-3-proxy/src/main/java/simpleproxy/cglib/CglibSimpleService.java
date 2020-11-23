package simpleproxy.cglib;

import lombok.extern.apachecommons.*;

@CommonsLog
public class CglibSimpleService {
    public void foo() {
        log.info("----> foo()");
        this.bar();
    }

    public void bar() {
        log.info("----> bar()");
    }
}
