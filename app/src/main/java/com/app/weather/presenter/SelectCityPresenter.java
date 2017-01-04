package com.app.weather.presenter;

import android.content.Context;
import android.util.Log;

import com.app.weather.executor.ParsingExecutor;
import com.app.weather.model.CityResponse;
import com.app.weather.model.CityWeather;
import com.app.weather.retrofit.ApiController;
import com.app.weather.retrofit.ApiDataReceiveCallback;
import com.app.weather.retrofit.NetworkConstants;
import com.app.weather.retrofit.RequestBuilder;
import com.app.weather.utils.WrLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by niranjan on 12/28/16.
 * @author niranjan
 * @since 12/28/16
 * @see com.app.weather.activity.SelectCityActivity
 */

public class SelectCityPresenter extends BasePresenterImpl<SelectCityView> implements ApiDataReceiveCallback {

    @Inject
    ApiController apiController;

    @Inject
    ParsingExecutor parsingExecutor;

    @Inject
    SelectCityPresenter(Context baseContext) {
        super(baseContext);
    }

    public void getCurrentWeatherData(String latitude, String longitude) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lat", String.valueOf(latitude));
        map.put("lon", String.valueOf(longitude));
        RequestBuilder requestBuilder = new RequestBuilder(NetworkConstants.API_FETCH_CITY_WEATHER);
        requestBuilder.setExtraParameters(map);
        apiController.hitApi(requestBuilder, this);
    }

    public void findCites(String keyword) {
        HashMap<String, String> map = new HashMap<>();
        map.put("q", keyword);
        RequestBuilder requestBuilder = new RequestBuilder(NetworkConstants.API_FIND_CITY);
        requestBuilder.setExtraParameters(map);
        apiController.hitApi(requestBuilder, this);
    }

    @Override
    public void onDataReceived(String response, int type) {
        Log.i("Response", response);
        switch (type) {
            case NetworkConstants.API_FIND_CITY:
                parseCityListResponse(response);
                break;
            case NetworkConstants.API_FETCH_CITY_WEATHER:
                parseCurrentLocationResponse(response);

        }
    }

    @Override
    public void onError(int type) {

    }

    /**
     * Created by niranjan on 12/28/16.
     * @author niranjan
     * @since 12/28/16
     * @see SelectCityPresenter#onDataReceived(String, int)
     */
    private void parseCurrentLocationResponse(String response) {
        parsingExecutor.execute(CityWeather.class, response, new ParsingExecutor.ParsingCallback<CityWeather>() {
            @Override
            public void onParsingCompleted(CityWeather currentWeather) {
                try {
                    WrLogger.d(currentWeather.getName());
                    List<CityWeather> cityWeatherList = new ArrayList<CityWeather>();
                    cityWeatherList.add(currentWeather);
                    view.onWeatherResponseCame(cityWeatherList);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * Created by niranjan on 12/28/16.
     * @author niranjan
     * @since 12/28/16
     * @see SelectCityPresenter#onDataReceived(String, int)
     */
    private void parseCityListResponse(String response) {
        parsingExecutor.execute(CityResponse.class, response, new ParsingExecutor.ParsingCallback<CityResponse>() {
            @Override
            public void onParsingCompleted(CityResponse cityResponse) {
                try {
                    if (null != cityResponse)
                        view.onWeatherResponseCame(cityResponse.getList());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
