package com.example.dreamkatchtestapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    public static SharedPreferences sharedPreferences;
    public static String PREFERENCE_FILE_KEY = "com_example_dreamkatch";

    public static void initiolizeSharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        setPreferences(SharedPrefs.sharedPreferences);

    }


    public static SharedPreferences getPreferences() {
        return sharedPreferences;
    }

    public static void setPreferences(SharedPreferences preferences) {
        SharedPrefs.sharedPreferences = preferences;
    }

    public static void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key, String def) {
        return sharedPreferences.getString(key, def);
    }

    public static void setInt(String key, int value){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key, int def){
        return sharedPreferences.getInt(key, def);
    }


    public static class Key {
        public static final String USER_ID = "user_id";
        public static final String POSITION = "position";

    }


}
