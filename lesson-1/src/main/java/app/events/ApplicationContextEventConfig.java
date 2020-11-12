package app.events;

import lombok.extern.apachecommons.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@CommonsLog
@Component
public class ApplicationContextEventConfig implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("Context event ---------> " + event.toString());
    }
}
