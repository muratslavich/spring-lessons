package circular.post;

import lombok.*;
import org.springframework.stereotype.*;

import javax.annotation.*;

/*
* Example of circular dependency, possible only with constructor injections
* */

@Component
@Getter
public class FirstBean {
    private final SecondBean secondBean;

    public FirstBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

    @PostConstruct
    public void init() {
        secondBean.setFirstBean(this);
    }
}
