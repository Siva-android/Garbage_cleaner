package com.garbagecleaner;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tringapps Admin on 25-Jul-16.
 */
public class OtpCleanerApp extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

    }

    public static Context getAppContext() {
        return sContext;
    }
}
