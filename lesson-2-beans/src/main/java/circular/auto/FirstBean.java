package circular.auto;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/*
* Example of circular dependency, possible only with constructor injections
* */

@Component
public class FirstBean {
    @Autowired
    SecondBean secondBean;
}
