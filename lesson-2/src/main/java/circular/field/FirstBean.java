package circular.field;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class FirstBean {
    private SecondBean secondBean;

    public SecondBean getSecondBean() {
        return secondBean;
    }

    @Autowired
    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
