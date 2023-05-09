package home.bruce.lesson4;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test") // -Dspring.profiles.active=test
public class Pink {
}
