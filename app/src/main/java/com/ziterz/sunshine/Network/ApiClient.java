package com.ziterz.sunshine.Network;

import com.ziterz.sunshine.Network.Response.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ziterz on 8/6/2017.
 */

public interface ApiClient {
    @GET("/data/2.5/weather")
    Call<Weather> getWeather(@Query("q") String q,
                             @Query("appid") String appid);
}
