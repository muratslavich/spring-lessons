package circular.auto;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class SecondBean {
    @Autowired
    FirstBean firstBean;
}
