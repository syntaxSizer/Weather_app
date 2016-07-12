package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Units implements JsonPopulator {


    private String temperature;

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }


    public String getTemperature() {
        return temperature;
    }
}

