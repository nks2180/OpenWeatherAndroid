package com.app.weather.presenter;

import com.app.weather.model.CityWeather;

import java.util.List;

/**
 * Created by niranjan on 12/29/16.
 */

public interface SelectCityView  extends BaseView{

    public void onWeatherResponseCame(List<CityWeather> cityWeatherList);
}
