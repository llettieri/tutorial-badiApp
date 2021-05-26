package ch.bbcag.tutorial_badiapp.helper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import ch.bbcag.tutorial_badiapp.model.Basin;
import ch.bbcag.tutorial_badiapp.model.OutdoorPool;

public class HowWarmJsonParser {
    public static OutdoorPool createOutdoorPoolFromJsonString(String outdoorPoolJsonString) throws JSONException {
        OutdoorPool outdoorPool = new OutdoorPool();
        JSONObject jsonObj = new JSONObject();

        outdoorPool.setId(Integer.parseInt(jsonObj.getString("badid")));
        outdoorPool.setName(jsonObj.getString("badname"));
        outdoorPool.setCanton(jsonObj.getString("kanton"));
        outdoorPool.setLocation(jsonObj.getString("ort"));

        JSONObject basinJson = jsonObj.getJSONObject("becken");
        Iterator keys = basinJson.keys();

        while (keys.hasNext()) {
            Basin basin = new Basin();
            String key = (String) keys.next();
            JSONObject subObj = basinJson.getJSONObject(key);

            basin.setName(subObj.getString("beckenname"));
            basin.setTemp(Double.parseDouble(subObj.getString("temp")));

            outdoorPool.addBasin(basin);
        }

        return outdoorPool;
    }
}
