package matrial.aka.weather;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import matrial.aka.weather.data.Channel;
import matrial.aka.weather.service.YahooWeatherCallBack;
import matrial.aka.weather.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements YahooWeatherCallBack {

    private ImageView weatherImageView;
    private TextView  temperture , conditionTextView, locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherImageView = (ImageView) findViewById(R.id.weather_icon_imageView);
        temperture = (TextView)findViewById(R.id.temperture_text);
        conditionTextView = (TextView)findViewById(R.id.condition_text);
        locationTextView =(TextView)findViewById(R.id.location_TextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        service.refershWeather("this is happeinig");
        dialog.show();
    }
    @Override
    public void serviceSuccess(Channel channel){
        dialog.hide();

    }

    @Override
    public void serviceFailure(Exception exception){
        dialog.hide();
        Toast.makeText(this, exception.getMessage(),Toast.LENGTH_LONG).show();
    }
}
