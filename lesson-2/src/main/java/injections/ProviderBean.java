package injections;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.inject.*;

@Component
public class ProviderBean {
    @Autowired
    private Provider<PrototypeBean> myPrototypeBeanProvider;

    public PrototypeBean getPrototypeInstance() {
        return myPrototypeBeanProvider.get();
    }
}
