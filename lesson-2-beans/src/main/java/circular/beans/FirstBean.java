package circular.beans;

import lombok.*;
import org.springframework.stereotype.*;

/*
* Example of circular dependency, possible only with constructor injections
* */

@Component
@AllArgsConstructor
public class FirstBean {
    final SecondBean secondBean;
}
