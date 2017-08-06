package com.ziterz.sunshine.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ziterz on 8/6/2017.
 */

public class ApiService {

    public static String API_KEY = "14d8169f08c8d15fc1f2a274a59bfcdb";
    public static String BASE_URL = "http://api.openweathermap.org";
    public static String BASE_PATH = "/data/2.5";

    public static <S> S createService(Class<S> serviceClass) {
        final OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .create();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return builder.create(serviceClass);
    }
}
