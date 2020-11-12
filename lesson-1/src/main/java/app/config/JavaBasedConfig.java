package app.config;

import app.beans.*;
import org.springframework.context.annotation.*;

@Configuration
public class JavaBasedConfig {

    @Bean
    public OtherThing otherThing() {
        return new OtherThing();
    }

    @Bean
    public Thing thing() {
        return new Thing(otherThing());
    }

}
