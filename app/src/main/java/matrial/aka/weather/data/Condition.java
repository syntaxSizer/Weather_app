package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Condition implements JsonPopulator {


    private int code;
    private int temperature;
    private String description;

    @Override
    public void populate(JSONObject data) {

        code = data.optInt("code");
        temperature = data.optInt("temp");
        description = data.optString("text");
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public int getTemperature() {
        return temperature;
    }
}

