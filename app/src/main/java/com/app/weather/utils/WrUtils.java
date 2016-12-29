package com.app.weather.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

/**
 * Created by niranjan on 12/28/16.
 */

public class WrUtils {

    public static double convertKelvinToCelcius(double kelvin){
        return kelvin - Constants.ONE_KELVIN_TO_CELSIUS;
    }

    public static void showToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    public static void loadImageThroughPicasso(final Context mContext, String mPicURL, final ImageView imgVw, int placeholderDrawable) {
        Drawable defaultDrawable = ContextCompat.getDrawable(mContext, placeholderDrawable);
        if (URLUtil.isValidUrl(mPicURL)) {
            Picasso.with(mContext).load(mPicURL).placeholder(defaultDrawable).error(defaultDrawable).into(imgVw, new Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError() {
                }
            });
        } else {
            Picasso.with(mContext).load(placeholderDrawable).error(defaultDrawable).into(imgVw);
        }
    }

    public static String formatDecimal(double d){
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(d);
    }

    public static void openAppSettingsScreen(final Context mContext, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        Window window = builder.create().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setMessage(message).setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                goToSettings(mContext);
            }
        }).setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }

    private static void goToSettings(Context context) {
        Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + context.getPackageName()));
        myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
        myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myAppSettings);
    }
}
