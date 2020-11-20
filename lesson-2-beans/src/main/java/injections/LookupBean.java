package injections;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class LookupBean {

    @Lookup
    public PrototypeBean getPrototype() {
        return null;
    }

}
