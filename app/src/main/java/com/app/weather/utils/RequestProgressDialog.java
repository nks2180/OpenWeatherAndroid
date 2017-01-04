package com.app.weather.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */

public class RequestProgressDialog  extends ProgressDialog
{
    public int reqCode = 0;

    public RequestProgressDialog(Context context, String message, int requesCode)
    {
        super(context);
        reqCode = requesCode;
        setMessage(message);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public RequestProgressDialog(Context context, String message, int requesCode, int theme)
    {
        super(context, theme);
        reqCode = requesCode;
        setMessage(message);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }
}
