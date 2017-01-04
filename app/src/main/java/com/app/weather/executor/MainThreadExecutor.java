package com.app.weather.executor;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */

public class MainThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}