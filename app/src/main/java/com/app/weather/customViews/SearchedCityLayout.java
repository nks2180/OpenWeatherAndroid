package com.app.weather.customViews;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.weather.R;
import com.app.weather.model.CityWeather;
import com.app.weather.utils.WrUtils;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by niranjan on 12/28/16.
 */

public class SearchedCityLayout extends RelativeLayout {

    Context mContext;

    @BindView(R.id.imgVw_weather)
    ImageView imgVwWeather;
    @BindView(R.id.txtVw_cityName)
    WrTextView txtVwCityName;
    @BindView(R.id.txtVw_temperature)
    WrTextView txtVwTemperature;
    @BindView(R.id.txtVw_wind)
    WrTextView txtVwWind;
    @BindView(R.id.txtVw_coordinates)
    WrTextView txtVwCoordinates;

    @BindString(R.string.str_max_temp)
    String maxTempStr;
    @BindString(R.string.str_min_temp)
    String minTempStr;
    @BindString(R.string.str_lat)
    String latStr;
    @BindString(R.string.str_long)
    String longStr;
    @BindString(R.string.str_wind)
    String windStr;
    @BindString(R.string.str_cloud)
    String cloudStr;
    @BindString(R.string.str_humidity)
    String humidityStr;
    @BindString(R.string.str_weather_icon)
    String weatherIconStr;

    public SearchedCityLayout(Context context) {
        super(context);
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_city, this, true);
        ButterKnife.bind(this, view);
    }

    public void loadDataIntoView(CityWeather weather) {
        String maxTemp = String.format(maxTempStr, String.valueOf(weather.getMain().getTempMax()));
        String minTemp = String.format(minTempStr, String.valueOf(weather.getMain().getTempMin()));
        String lattitude = String.format(latStr, WrUtils.formatDecimal(weather.getCoord().getLat()));
        String longitude = String.format(latStr, WrUtils.formatDecimal(weather.getCoord().getLon()));

        String wind = String.format(windStr, weather.getWind().getSpeed());
        String cloud = String.format(cloudStr, weather.getClouds().getAll());
        String pressure = String.format(humidityStr, weather.getMain().getPressure());

        String cityName = weather.getName();
        if (null != weather.getSys() && !TextUtils.isEmpty(weather.getSys().getCountry()))
            cityName = cityName + ", " + weather.getSys().getCountry();
        txtVwCityName.setText(cityName);
        txtVwCoordinates.setText(lattitude + getResources().getString(R.string.str_bullet) + longitude);
        txtVwTemperature.setText(maxTemp + getResources().getString(R.string.str_bullet) + minTemp);
        txtVwWind.setText(wind + getResources().getString(R.string.str_bullet) + pressure + getResources().getString(R.string.str_bullet) + cloud);

        if (null != weather.getWeather() && weather.getWeather().size() > 0) {
            String iconUrl = String.format(weatherIconStr, weather.getWeather().get(0).getIcon());
            WrUtils.loadImageThroughPicasso(mContext, iconUrl, imgVwWeather, R.color.transparent);
        }
    }

}

