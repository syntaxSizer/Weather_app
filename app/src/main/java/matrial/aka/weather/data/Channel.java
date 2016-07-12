package matrial.aka.weather.data;

import org.json.JSONObject;

/**
 * Created by geckozila on 15/06/16.
 */
public class Channel implements JsonPopulator {

    private Item item;
    private Units units;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }


    @Override
    public void populate(JSONObject data) {
        units = new Units();
        units.populate(data.optJSONObject("unites"));
        item = new Item();
        item.populate(data.optJSONObject("item"));

    }

}
