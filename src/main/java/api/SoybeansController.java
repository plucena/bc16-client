package api;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lkolisko.hyperledger.example.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SoybeansController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/soybeans/{id}")
    public Soybeans getSoybeans(@PathVariable Long id) {

        String soybeans  = "";
        try {soybeans = HFJavaSDKBasicExample.getSoybeans(id);} catch(Exception e){};

        System.out.print(soybeans);
        Soybeans newAsset = Soybeans.fromJSONString(soybeans,id);

        return newAsset;
    }


    @PostMapping(path = "/soybeans", consumes = "application/json", produces = "application/json")
    public void addSoybeans(@RequestBody Soybeans soybeans) {
        System.out.println("ws");
        String sid = "" + soybeans.getId();
        System.out.println(sid + ":" + soybeans.getFarm() + ":" +  soybeans.getHarvestdate());
        try {HFJavaSDKBasicExample.createSoybeans(sid, soybeans.getFarm(), soybeans.getHarvestdate());} catch(Exception e){};
    }

}   