package com.example.dreamkatchtestapp;

import androidx.multidex.MultiDexApplication;

import com.example.dreamkatchtestapp.preferences.SharedPrefs;

public class App extends MultiDexApplication {
    public static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefs.initiolizeSharedPref(this);
    }
}
