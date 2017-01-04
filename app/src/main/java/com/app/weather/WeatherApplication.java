package com.app.weather;

import android.app.Application;

import com.app.weather.component.ApplicationComponent;
import com.app.weather.component.DaggerApplicationComponent;
import com.app.weather.module.ApplicationModule;
import com.app.weather.module.DatabaseModule;
import com.app.weather.module.NetModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */
public class WeatherApplication extends Application {

    private static final String BASE_URL = "http://api.openweathermap.org/";

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setApplicationComponent();
    }

    private void setApplicationComponent() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(BASE_URL))
                .databaseModule(new DatabaseModule(this))
                .build();

        mComponent.inject(this);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
