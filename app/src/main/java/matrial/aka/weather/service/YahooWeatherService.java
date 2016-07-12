package matrial.aka.weather.service;

import android.net.Uri;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import matrial.aka.weather.data.Channel;

/**
 * Created by geckozila on 15/06/16.
 */
public class YahooWeatherService {
    private  YahooWeatherCallBack callBack;
    private String location;
    private Exception error;

    public YahooWeatherService(YahooWeatherCallBack callBack){
        this.callBack = callBack;
    }

    public String getLocation(){
        return location;
    }

    public  void refershWeather(final String location){
        // Void is progress
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {


                   String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")"), location;
                String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));
                try {
                    URL url = new URL(endpoint);
                    URLConnection connection= url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reder = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reder.readLine()) != null){
                        result.append(line);

                    }
                    return  result.toString();

                } catch (Exception e) {
                    error = e;
                }
                return null;
            }
            @Override
            public void onPostExecute(String s){
                if(s == null && error != null){
                    callBack.serviceFailure(error);
                    return ;
                }
                try {
                    JSONObject data = new JSONObject(s);
                    JSONObject queryresualt = data.optJSONObject("query");
                    int count = queryresualt.optInt("count");

                    if(count == 0) {
                        callBack.serviceFailure(new LocationWeatherException("No Weather information found for "+ location));
                    return ;
                    }

                    Channel channel = new Channel();
                    channel.populate(queryresualt.optJSONObject("result").optJSONObject("channel"));

                    callBack.serviceSuccess(channel);

                } catch (JSONException e) {
                    callBack.serviceFailure(e);
                }
            }

        }.execute(location);

    }
    // inner class
    public class LocationWeatherException extends  Exception{
        public LocationWeatherException(String detailsMessage){
            super(detailsMessage);

        }

    }
}
