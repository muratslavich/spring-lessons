package annotationproxy;

import lombok.extern.apachecommons.*;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@CommonsLog
@Component
public class AspectionalAdvice {

    @Before("@annotation(Aspectional)")
    public void doLog() {
        log.info("----> advice");
    }

}
