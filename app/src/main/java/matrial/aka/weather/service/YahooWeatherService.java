package matrial.aka.weather.service;

import android.os.AsyncTask;

/**
 * Created by geckozila on 15/06/16.
 */
public class YahooWeatherService {
    private  YahooWeatherCallBack callBack;
    private String location;

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
                return null;
            }
            @Override
            public void onPostExecute(String s){
                super.onPostExecute(s);
            }

        }.execute(location);

    }
}
