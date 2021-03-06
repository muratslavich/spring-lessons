package circular.lazy;

import lombok.extern.apachecommons.*;
import org.springframework.stereotype.*;

@Component
@CommonsLog
public class SecondBean {
    final FirstBean firstBean;

    public SecondBean(FirstBean firstBean) {
        log.info("----> lazy bean is initialized");
        this.firstBean = firstBean;
    }
}
