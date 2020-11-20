package circular.field;

import org.springframework.stereotype.*;

@Component
public class FirstBean {
    private SecondBean secondBean;

    public SecondBean getSecondBean() {
        return secondBean;
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
