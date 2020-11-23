package annotationproxy;

import lombok.extern.apachecommons.*;
import org.aspectj.lang.annotation.*;

@Aspect
@CommonsLog
public class AspectionalAdvice {

    @Before("@annotation(Aspectional)")
    public void doLog() {
        log.info("----> advice");
    }

}
