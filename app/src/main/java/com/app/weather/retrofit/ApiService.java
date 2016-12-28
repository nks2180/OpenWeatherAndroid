package com.app.weather.retrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by niranjan on 03/01/16.
 * Custom interface to declare all API calls
 */

//   http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=ff48573957bf4a69793c6d9e4d89ddcc
public interface ApiService {

    @GET("data/2.5/weather")
    Call<String> getCityWeather(@QueryMap Map<String, String> requestParams);

    @GET("data/2.5/find")
    Call<String> findCity(@QueryMap Map<String, String> requestParams);

}
