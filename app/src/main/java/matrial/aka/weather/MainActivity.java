package matrial.aka.weather;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import matrial.aka.weather.data.Channel;
import matrial.aka.weather.data.Item;
import matrial.aka.weather.service.YahooWeatherCallBack;
import matrial.aka.weather.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements YahooWeatherCallBack {

    private ImageView weatherImageView;
    private TextView  temperature;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherImageView = (ImageView) findViewById(R.id.weather_icon_imageView);
        temperature = (TextView)findViewById(R.id.temperature_text);
        conditionTextView = (TextView)findViewById(R.id.condition_text);
        locationTextView =(TextView)findViewById(R.id.location_TextView);
        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();


        service.refershWeather("Austin , TX");

    }
    @Override
    public void serviceSuccess(Channel channel){
        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(),null,getPackageName());
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);
        weatherImageView.setImageDrawable(weatherIconDrawable);
        locationTextView.setText(service.getLocation());
        temperature.setText(item.getCondition().getTemperature() +"\u00B0 "+ channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
    }

    @Override
    public void serviceFailure(Exception exception){
        dialog.hide();
        Toast.makeText(this, exception.getMessage(),Toast.LENGTH_LONG).show();
    }
}
