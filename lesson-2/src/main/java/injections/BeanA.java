package injections;

import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
@Getter
public class BeanA {
    final PrototypeBean beanB;
}
