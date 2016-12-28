package com.app.weather.component;

import com.app.weather.WeatherApplication;
import com.app.weather.activity.SelectCityActivity;
import com.app.weather.module.ApplicationModule;
import com.app.weather.module.DatabaseModule;
import com.app.weather.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by niranjan on 12/29/16.
 */
@Singleton
@Component(modules={ApplicationModule.class, NetModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(WeatherApplication materialApplication);


    void inject(SelectCityActivity selectCityActivity);
}
