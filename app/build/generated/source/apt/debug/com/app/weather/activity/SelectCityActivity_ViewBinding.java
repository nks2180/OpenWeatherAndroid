// Generated code from Butter Knife. Do not modify!
package com.app.weather.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.weather.R;
import com.app.weather.customViews.WrTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectCityActivity_ViewBinding<T extends SelectCityActivity> implements Unbinder {
  protected T target;

  private View view2131492989;

  private View view2131492988;

  @UiThread
  public SelectCityActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_search, "field 'btnSearch' and method 'fetchCityWeather'");
    target.btnSearch = Utils.castView(view, R.id.btn_search, "field 'btnSearch'", Button.class);
    view2131492989 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fetchCityWeather();
      }
    });
    target.edtTxtSearchCity = Utils.findRequiredViewAsType(source, R.id.edtTxt_searchCity, "field 'edtTxtSearchCity'", AutoCompleteTextView.class);
    view = Utils.findRequiredView(source, R.id.imgVw_currentLocation, "field 'imgVwCurrentLocation' and method 'callLocation'");
    target.imgVwCurrentLocation = Utils.castView(view, R.id.imgVw_currentLocation, "field 'imgVwCurrentLocation'", ImageView.class);
    view2131492988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.callLocation();
      }
    });
    target.lnrLytSearchedCity = Utils.findRequiredViewAsType(source, R.id.lnrLyt_searchedCity, "field 'lnrLytSearchedCity'", LinearLayout.class);
    target.txtVwSelectCity = Utils.findRequiredViewAsType(source, R.id.txtVw_selectCity, "field 'txtVwSelectCity'", WrTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnSearch = null;
    target.edtTxtSearchCity = null;
    target.imgVwCurrentLocation = null;
    target.lnrLytSearchedCity = null;
    target.txtVwSelectCity = null;

    view2131492989.setOnClickListener(null);
    view2131492989 = null;
    view2131492988.setOnClickListener(null);
    view2131492988 = null;

    this.target = null;
  }
}
