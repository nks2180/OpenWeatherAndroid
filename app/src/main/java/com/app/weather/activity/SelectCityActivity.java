package com.app.weather.activity;

import android.Manifest;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.weather.R;
import com.app.weather.component.ApplicationComponent;
import com.app.weather.customViews.SearchedCityLayout;
import com.app.weather.customViews.WrTextView;
import com.app.weather.model.CityWeather;
import com.app.weather.presenter.SelectCityPresenter;
import com.app.weather.presenter.SelectCityView;
import com.app.weather.utils.RequestProgressDialog;
import com.app.weather.utils.WrLogger;
import com.app.weather.utils.WrUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by niranjan on 12/28/16.
 * @author niranjan
 * @since 12/28/16
 */

@RuntimePermissions
public class SelectCityActivity extends BaseViewPresenterActivity<SelectCityPresenter> implements SelectCityView, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    @Inject
    SelectCityPresenter selectCityPresenter;

    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.edtTxt_searchCity)
    AutoCompleteTextView edtTxtSearchCity;
    @BindView(R.id.imgVw_currentLocation)
    ImageView imgVwCurrentLocation;
    @BindView(R.id.lnrLyt_searchedCity)
    LinearLayout lnrLytSearchedCity;
    @BindView(R.id.txtVw_selectCity)
    WrTextView txtVwSelectCity;

    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest = new LocationRequest();

    public final int REQUEST_LOCATION = 1001;
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    private Location mCurrentLocation;

    Context mContext;
    RequestProgressDialog apiProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        getSupportActionBar().setTitle("Search City");

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();

        edtTxtSearchCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    fetchCityWeather();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected int getMainLayout() {
        return R.layout.activity_search_city;
    }

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    @Override
    public void initializePresenter() {
        super.initializePresenter(selectCityPresenter, this);
    }


    /**
     * Created by niranjan on 12/28/16.
     * @author niranjan
     * @since 12/28/16
     * @see #callLocation()
     */
    public void fetchCurrentLocationWeather() {
        if (null != mCurrentLocation) {
            selectCityPresenter.getCurrentWeatherData(String.valueOf(mCurrentLocation.getLatitude()), String.valueOf(mCurrentLocation.getLongitude()));
            apiProgressDialog = WrUtils.getRequestProgressDialog(mContext, "Please wait..");
            apiProgressDialog.show();
        } else
            WrUtils.showToast(mContext, getString(R.string.toast_enter_city_first));
    }

    /**
     * Created by niranjan on 12/28/16.
     * @author niranjan
     * @since 12/28/16
     * @see SelectCityPresenter#parseCurrentLocationResponse(String)
     */
    @Override
    public void onWeatherResponseCame(List<CityWeather> citiWeathers) {
        if (null != apiProgressDialog && apiProgressDialog.isShowing())
            apiProgressDialog.dismiss();
        lnrLytSearchedCity.removeAllViews();
        if (null != citiWeathers && citiWeathers.size() > 0) {
            lnrLytSearchedCity.setVisibility(View.VISIBLE);
            txtVwSelectCity.setVisibility(View.VISIBLE);
            for (CityWeather weather : citiWeathers) {
                SearchedCityLayout cityLayout = new SearchedCityLayout(mContext);
                cityLayout.loadDataIntoView(weather);
                lnrLytSearchedCity.addView(cityLayout);
            }
        }
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void callLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mCurrentLocation != null) {
            stopLocationUpdates();
            fetchCurrentLocationWeather();
        } else {
            askToChangeLocationSetting();
        }

    }

    @OnClick(R.id.btn_search)
    public void fetchCityWeather() {
        String searchedText = edtTxtSearchCity.getText().toString().trim();

        if (!TextUtils.isEmpty(searchedText)) {
            WrUtils.hideKeyboard(edtTxtSearchCity, mContext);
            selectCityPresenter.findCites(searchedText);
            apiProgressDialog = WrUtils.getRequestProgressDialog(mContext, "Please wait..");
            apiProgressDialog.show();
        } else
            WrUtils.showToast(mContext, getString(R.string.toast_enter_city_first));
    }

    @OnClick(R.id.imgVw_currentLocation)
    public void fetchCurrentLocation() {
        edtTxtSearchCity.setText("");
        WrUtils.hideKeyboard(edtTxtSearchCity, mContext);
        SelectCityActivityPermissionsDispatcher.callLocationWithCheck(SelectCityActivity.this);
    }


    /**
     * Created by niranjan on 12/28/16.
     * @author niranjan
     * @since 12/28/16
     * @see #callLocation()
     */
    private void askToChangeLocationSetting() {

        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());

        result.setResultCallback(result1 -> {
            final Status status = result1.getStatus();
            final LocationSettingsStates s = result1.getLocationSettingsStates();
            switch (status.getStatusCode()) {
                case LocationSettingsStatusCodes.SUCCESS:
                    Log.d("onResult", "SUCCESS");
                    break;
                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                    Log.d("onResult", "RESOLUTION_REQUIRED");
                    try {
                        status.startResolutionForResult(SelectCityActivity.this, REQUEST_LOCATION);
                    } catch (IntentSender.SendIntentException e) {
                    }
                    break;
                case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                    Log.d("onResult", "UNAVAILABLE");
                    break;
            }
        });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        WrLogger.d("onConnected");
        //SelectCityActivityPermissionsDispatcher.callLocationWithCheck(SelectCityActivity.this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        WrLogger.d("onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        WrLogger.d("onConnectionFailed");
    }

    @Override
    public void onLocationChanged(Location location) {
        if (null != location) {
            mCurrentLocation = location;
            stopLocationUpdates();
            fetchCurrentLocationWeather();
        }
    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this).setResultCallback(status -> {
            //mRequestingLocationUpdates = true;
        });
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient,
                this
        ).setResultCallback(status -> {
            // mRequestingLocationUpdates = false;
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SelectCityActivityPermissionsDispatcher.onRequestPermissionsResult(SelectCityActivity.this, requestCode, grantResults);
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    void onLocationNeverAskAgain() {
        WrUtils.openAppSettingsScreen(mContext, getResources().getString(R.string.permission_location_rationale));
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    void onLocationPermissionDenied() {
        WrUtils.showToast(mContext, "Location permission denied");
    }
}
