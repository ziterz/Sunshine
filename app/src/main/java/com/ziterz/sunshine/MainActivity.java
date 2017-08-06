package com.ziterz.sunshine;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ziterz.sunshine.Network.Request.WeatherRequest;
import com.ziterz.sunshine.Network.Response.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WeatherRequest.OnWeatherRequestListener {

    //Inject Views
    @BindView(R.id.tv_city)
    TextView tvCity;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_humidity)
    TextView tvHumidity;

    @BindView(R.id.tv_main)
    TextView tvMain;

    @BindView(R.id.tv_temp)
    TextView tvTemp;

    private ProgressDialog progressDialog;
    private WeatherRequest mWeatherRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWeatherRequest = new WeatherRequest(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Harap tunggu");
        progressDialog.show();

        String city = "Bandung,ID";
        mWeatherRequest.CallApi(city);
    }

    @Override
    public void onRequestWeatherSuccess(Weather weatherResponse) {
        progressDialog.dismiss();
        tvCity.setText(weatherResponse.getCity());
        tvDescription.setText(weatherResponse.getListWeather().get(0).getDescription());
        double derajat = weatherResponse.getWeaterMain().getTemp()-273;
        tvTemp.setText(derajat+" C");
        tvHumidity.setText(weatherResponse.getWeaterMain().getHumidity()+" %");
        tvMain.setText(weatherResponse.getListWeather().get(0).getMain());
    }

    @Override
    public void onRequestWeatherFailure(String message) {

    }
}
