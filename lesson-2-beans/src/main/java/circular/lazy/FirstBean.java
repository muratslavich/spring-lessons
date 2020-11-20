package circular.lazy;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

/*
* Example of circular dependency, possible only with constructor injections
* */

@Component
public class FirstBean {
    final SecondBean secondBean;

    public FirstBean(@Lazy SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
