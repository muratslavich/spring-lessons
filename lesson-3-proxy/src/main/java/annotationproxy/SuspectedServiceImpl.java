package annotationproxy;

import lombok.extern.apachecommons.*;
import org.springframework.stereotype.*;

@CommonsLog
@Service
public class SuspectedServiceImpl implements SuspectedService {

    @Override
    @Aspectional
    public void foo() {
        log.info("----> foo");
        this.bar();
    }

    @Aspectional
    public void bar() {
        log.info("----> bar");
    }

}
