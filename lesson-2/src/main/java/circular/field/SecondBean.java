package circular.field;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class SecondBean {
    private FirstBean firstBean;

    public FirstBean getFirstBean() {
        return firstBean;
    }

    @Autowired
    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }
}
