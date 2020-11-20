package injections;

import lombok.extern.apachecommons.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

@Component("beanB")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@CommonsLog
public class PrototypeBean {
    public PrototypeBean() {
        log.info("----> Prototype is created");
    }
}
