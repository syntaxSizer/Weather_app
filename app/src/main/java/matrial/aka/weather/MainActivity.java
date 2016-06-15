package matrial.aka.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView weatherImageView;
    private TextView  temperture , conditionTextView, locationTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherImageView = (ImageView) findViewById(R.id.weather_icon_imageView);
        temperture = (TextView)findViewById(R.id.temperture_text);
        conditionTextView = (TextView)findViewById(R.id.condition_text);
        locationTextView =(TextView)findViewById(R.id.location_TextView);
    }
}
