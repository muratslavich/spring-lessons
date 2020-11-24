package annotationproxy;

import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "annotationproxy")
public class AspectjConfig {
}
