package com.app.weather.module;

import android.content.Context;

import com.app.weather.WeatherApplication;
import com.app.weather.executor.ParsingExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *  @author Niranjan
 *  @since 12/28/16
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
