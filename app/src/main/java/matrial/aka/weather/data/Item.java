package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Item implements  JsonPopulator {

    private Condition condition;

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));


    }

    public Condition getCondition() {
        return condition;
    }
}
