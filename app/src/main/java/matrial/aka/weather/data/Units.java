package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Units implements JsonPopulator {


    private String temperture;

    @Override
    public void poupolute(JSONObject jsonObject) {
        temperture = jsonObject.optString("temperture");

    }


    public String getTemperture() {
        return temperture;
    }
}

