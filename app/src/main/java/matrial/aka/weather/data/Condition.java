package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Condition implements  JsonPopulator {


    private int code;
    private int temperture;
    private String description;

    @Override
    public void poupolute(JSONObject jsonObject) {

        code = jsonObject.optInt("code");
        temperture = jsonObject.optInt("tem");
        description = jsonObject.optString("text");
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public int getTemperture() {
        return temperture;
    }
}

