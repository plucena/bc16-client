package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lkolisko.hyperledger.example.*;

@RestController
public class SoybeansController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/soybeans/{id}")
    public Soybeans getSoybeans(@PathVariable Long id) {

        String soybeans  = "";
        try {soybeans = HFJavaSDKBasicExample.getSoybeans(id);} catch(Exception e){};
         
        
        return new Soybeans(counter.incrementAndGet(),
                            soybeans);
    }
}