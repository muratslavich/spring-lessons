package app.beans.annotation;

import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
@Getter
public class AnnotationComponent {
    @Autowired
    private AnnotationService service;
}
