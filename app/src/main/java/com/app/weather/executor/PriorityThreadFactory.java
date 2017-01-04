package com.app.weather.executor;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */

public class PriorityThreadFactory implements ThreadFactory {

    private final int mThreadPriority;

    public PriorityThreadFactory(int threadPriority) {
        mThreadPriority = threadPriority;
    }

    @Override
    public Thread newThread(@NonNull final Runnable runnable) {
        Runnable wrapperRunnable = () -> {
            try {
                Process.setThreadPriority(mThreadPriority);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            runnable.run();
        };
        return new Thread(wrapperRunnable);
    }

}
