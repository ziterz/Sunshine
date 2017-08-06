package com.ziterz.sunshine.Network.Response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ziterz on 8/6/2017.
 */

public class Weather {
    @SerializedName("main")
    private WeaterMain weaterMain;

    @SerializedName("weather")
    private ArrayList<WeatherItem> listWeather = new ArrayList<>();

    @SerializedName("name")
    private String city;

    public WeaterMain getWeaterMain() {
        return weaterMain;
    }

    public void setWeaterMain(WeaterMain weaterMain) {
        this.weaterMain = weaterMain;
    }

    public ArrayList<WeatherItem> getListWeather() {
        return listWeather;
    }

    public void setListWeather(ArrayList<WeatherItem> listWeather) {
        this.listWeather = listWeather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
