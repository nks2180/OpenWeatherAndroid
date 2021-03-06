// This file was generated by PermissionsDispatcher. Do not modify!
package com.app.weather.activity;

import android.support.v4.app.ActivityCompat;
import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class SelectCityActivityPermissionsDispatcher {
  private static final int REQUEST_CALLLOCATION = 0;

  private static final String[] PERMISSION_CALLLOCATION = new String[] {"android.permission.ACCESS_FINE_LOCATION"};

  private SelectCityActivityPermissionsDispatcher() {
  }

  static void callLocationWithCheck(SelectCityActivity target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_CALLLOCATION)) {
      target.callLocation();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_CALLLOCATION)) {
        target.showRationaleForLocation(new CallLocationPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_CALLLOCATION, REQUEST_CALLLOCATION);
      }
    }
  }

  static void onRequestPermissionsResult(SelectCityActivity target, int requestCode, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_CALLLOCATION:
      if (PermissionUtils.getTargetSdkVersion(target) < 23 && !PermissionUtils.hasSelfPermissions(target, PERMISSION_CALLLOCATION)) {
        target.onLocationPermissionDenied();
        return;
      }
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.callLocation();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_CALLLOCATION)) {
          target.onLocationNeverAskAgain();
        } else {
          target.onLocationPermissionDenied();
        }
      }
      break;
      default:
      break;
    }
  }

  private static final class CallLocationPermissionRequest implements PermissionRequest {
    private final WeakReference<SelectCityActivity> weakTarget;

    private CallLocationPermissionRequest(SelectCityActivity target) {
      this.weakTarget = new WeakReference<>(target);
    }

    @Override
    public void proceed() {
      SelectCityActivity target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_CALLLOCATION, REQUEST_CALLLOCATION);
    }

    @Override
    public void cancel() {
      SelectCityActivity target = weakTarget.get();
      if (target == null) return;
      target.onLocationPermissionDenied();
    }
  }
}
