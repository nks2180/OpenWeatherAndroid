package com.app.weather.presenter;

import android.content.Intent;

public interface BaseView {
    void showErrorMessage(String message);
    void moveToNextScreen(Intent intent);


}
