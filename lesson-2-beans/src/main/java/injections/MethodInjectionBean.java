package injections;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class MethodInjectionBean {
    private PrototypeBean prototype;

    public PrototypeBean getPrototype() {
        return prototype;
    }

    @Autowired
    public void setPrototype(PrototypeBean prototype) {
        this.prototype = prototype;
    }
}
