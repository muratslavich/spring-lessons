package circular.post;

import lombok.*;
import lombok.extern.apachecommons.*;
import org.springframework.stereotype.*;

@Component
@CommonsLog
@Getter
public class SecondBean {
    private FirstBean firstBean;

    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }
}
