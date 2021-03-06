package com.example.android.mddeviantart.shared_preferences;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.mddeviantart.pojo.response.AuthResponse;
import com.google.gson.Gson;

public class SharedPreferencesManager {

    private static final String MY_APP_PREFERENCES = "m_preferences";
    private static final String AUTH_RESPONSE = "auth";

    private SharedPreferences sharedPrefs;
    private static SharedPreferencesManager instance;
    private SharedPreferences.Editor editor;


    private SharedPreferencesManager(Context context) {
        sharedPrefs = context.getApplicationContext().getSharedPreferences(MY_APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null)
            instance = new SharedPreferencesManager(context);
        return instance;
    }

    public void saveAuthResponse(String authResponse) {
        editor.putString(AUTH_RESPONSE, authResponse);
        editor.apply();
    }

    public AuthResponse getAuthResponse() {
        String authResponse = sharedPrefs.getString(AUTH_RESPONSE, "");
        if (authResponse == null || authResponse.equals("")) {
            return null;
        } else {
            return new Gson().fromJson(authResponse, AuthResponse.class);
        }
    }
}
