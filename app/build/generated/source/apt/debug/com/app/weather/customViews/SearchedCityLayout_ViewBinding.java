// Generated code from Butter Knife. Do not modify!
package com.app.weather.customViews;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.app.weather.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchedCityLayout_ViewBinding<T extends SearchedCityLayout> implements Unbinder {
  protected T target;

  @UiThread
  public SearchedCityLayout_ViewBinding(T target, View source) {
    this.target = target;

    target.imgVwWeather = Utils.findRequiredViewAsType(source, R.id.imgVw_weather, "field 'imgVwWeather'", ImageView.class);
    target.txtVwCityName = Utils.findRequiredViewAsType(source, R.id.txtVw_cityName, "field 'txtVwCityName'", WrTextView.class);
    target.txtVwTemperature = Utils.findRequiredViewAsType(source, R.id.txtVw_temperature, "field 'txtVwTemperature'", WrTextView.class);
    target.txtVwWind = Utils.findRequiredViewAsType(source, R.id.txtVw_wind, "field 'txtVwWind'", WrTextView.class);
    target.txtVwCoordinates = Utils.findRequiredViewAsType(source, R.id.txtVw_coordinates, "field 'txtVwCoordinates'", WrTextView.class);

    Resources res = source.getResources();
    target.maxTempStr = res.getString(R.string.str_max_temp);
    target.minTempStr = res.getString(R.string.str_min_temp);
    target.latStr = res.getString(R.string.str_lat);
    target.longStr = res.getString(R.string.str_long);
    target.windStr = res.getString(R.string.str_wind);
    target.cloudStr = res.getString(R.string.str_cloud);
    target.humidityStr = res.getString(R.string.str_humidity);
    target.weatherIconStr = res.getString(R.string.str_weather_icon);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imgVwWeather = null;
    target.txtVwCityName = null;
    target.txtVwTemperature = null;
    target.txtVwWind = null;
    target.txtVwCoordinates = null;

    this.target = null;
  }
}
