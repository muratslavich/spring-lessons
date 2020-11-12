package app.beans;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Thing {
    private final OtherThing other;
}
