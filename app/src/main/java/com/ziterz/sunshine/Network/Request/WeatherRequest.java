package com.ziterz.sunshine.Network.Request;

import com.ziterz.sunshine.Network.ApiClient;
import com.ziterz.sunshine.Network.ApiService;
import com.ziterz.sunshine.Network.Response.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ziterz on 8/6/2017.
 */

public class WeatherRequest {

    private ApiClient apiClient;
    private Call<Weather> request;
    private OnWeatherRequestListener listener;

    public WeatherRequest(OnWeatherRequestListener listener) {
        apiClient = ApiService.createService(ApiClient.class);
        this.listener = listener;
    }

    public void CallApi(String iak) {
        request = apiClient.getWeather(iak, ApiService.API_KEY);
        request.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response != null && response.isSuccessful()) {
                    //Variable untuk response dari body
                    Weather mWeather = response.body();
                    listener.onRequestWeatherSuccess(mWeather);
                } else {
                    listener.onRequestWeatherFailure("Respon Gagal");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                String errorMessage = t.getMessage() != null?
                        t.getMessage():"Tidak bisa konek ke server";
                listener.onRequestWeatherFailure(errorMessage);
            }
        });
    }

    public interface OnWeatherRequestListener {
        void onRequestWeatherSuccess(Weather weatherResponse);
        void onRequestWeatherFailure(String message);
    }
}
