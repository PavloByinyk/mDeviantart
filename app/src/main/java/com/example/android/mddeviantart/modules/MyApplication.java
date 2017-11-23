package com.example.android.mddeviantart.modules;


import android.app.Application;

import com.example.android.mddeviantart.shared_preferences.SharedPreferencesManager;

public class MyApplication extends Application {

    public static SharedPreferencesManager sharedPreferencesManager;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferencesManager = SharedPreferencesManager.getInstance(getApplicationContext());
    }
}
