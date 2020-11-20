package circular.beans;

import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class SecondBean {
    final FirstBean firstBean;
}
