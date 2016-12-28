package com.app.weather.module;

import android.content.Context;

import com.app.weather.WeatherApplication;
import com.app.weather.executor.ParsingExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by niranjan on 12/29/16.
 */
@Module
public class ApplicationModule {

    private final WeatherApplication lybrate;

    public ApplicationModule(WeatherApplication lybrate) {
        this.lybrate = lybrate;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return lybrate;
    }

    @Provides
    @Singleton
    ParsingExecutor providesParsingExecutor() {
        return new ParsingExecutor();
    }

}
