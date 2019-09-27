package api;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
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
        try {soybeans = HFJavaSDKBasicExample.getSoybeans(2);} catch(Exception e){};

        System.out.print(soybeans);
        Soybeans newAsset = Soybeans.fromJSONString(soybeans,id);

         
        /*
        JsonParser springParser = JsonParserFactory.getJsonParser(); 
        Map<String, Object> map = springParser.parseMap(soybeans);

        String mapArray[] = new String[map.size()];
        System.out.println("Items found: " + mapArray.length);

        String value =   (map.values().toArray()[0]).toString() ;  
        map = springParser.parseMap(value);
        mapArray = new String[map.size()];

        
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
		System.out.println(entry.getKey() + " = " + entry.getValue());
		i++;
        }   
        */

        return newAsset;
    }
}