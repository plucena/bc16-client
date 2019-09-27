package api;

import org.json.JSONObject;

public class Soybeans {

    private final long id;
    private final String farm;
    private final String harvestdate;


    public Soybeans(long id, String farm, String harvestdate) {
        this.id = id;
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
