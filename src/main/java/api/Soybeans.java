package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

public class Soybeans {

    @JsonProperty("id")
    private final long id;


    @JsonProperty("farm")
    private final String farm;

    @JsonProperty("harvestdate")
    private final String harvestdate;

    public Soybeans() {
        this.id =0;
        this.farm = "";
        this.harvestdate = "";
    }

    public Soybeans(long id, String farm, String harvestdate) {
        this.id = id;
        this.farm = farm;
        this.harvestdate = harvestdate;
    }


    public Soybeans(String id, String farm, String harvestdate) {
        this.id = Long.parseLong(id);
        this.farm = farm;
        this.harvestdate = harvestdate;
    }

    public long getId() {
        return id;
    }

    public String getFarm() {
        return farm;
    }

    public String getHarvestdate() {
        return harvestdate;
    }

    public static Soybeans fromJSONString(String json, Long sid)  {
        long id = sid;
        String farm = new JSONObject(json).getString("farm");
        String harvest_date = new JSONObject(json).getString("harvest_date");
        Soybeans asset = new Soybeans(id, farm, harvest_date);
        return asset;
    }
}
