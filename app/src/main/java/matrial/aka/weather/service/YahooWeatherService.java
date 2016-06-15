package matrial.aka.weather.service;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

    public  void refershWeather(String location){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {

                String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));
                String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")"), location;
                try {
                    URL url = new URL(endpoint);
                    URLConnection connection= url.openConnection();
                } catch (MalformedURLException e) {
                    error = e;
                    return null;
                } catch (IOException e) {
                    error = e;
                    return null;
                }
                return null;
            }
            @Override
            public void onPostExecute(String s){
                super.onPostExecute(s);
            }

        }.execute(location);

    }
}
