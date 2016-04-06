package com.example.location.util;

import android.app.Application;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/3/30.
 * 用于显示overflow button，而不局限于手机型号
 */
public class UIApplication extends Application {
    public void onCreate() {        try {
        ViewConfiguration config = ViewConfiguration.get(this);
        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
        if (menuKeyField != null) {
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        }
    }
    catch (Exception ex) {
        // Ignore
    }
        super.onCreate();
    }
}