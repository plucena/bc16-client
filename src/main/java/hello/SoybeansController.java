package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoybeansController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/soybeans/{id}")
    public Soybeans getSoybeans(@PathVariable Long id) {
        return new Soybeans(counter.incrementAndGet(),
                            String.format(template, 1));
    }
}