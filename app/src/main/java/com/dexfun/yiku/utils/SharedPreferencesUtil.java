package com.dexfun.yiku.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;


import com.dexfun.yiku.MainClass;

import java.util.Map;
import java.util.Set;

public class SharedPreferencesUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static final String FILE_NAME = "share_data";

    public static SharedPreferencesUtil getInstance() {
        SharedPreferencesUtil single;
        synchronized (SharedPreferencesUtil.class) {
            single = new SharedPreferencesUtil();
        }
        return single;
    }

    public SharedPreferencesUtil() {
        sp = MainClass.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
        editor.apply();
    }

    public void put(String key, @Nullable String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public void put(String key, int value) {
        editor.putInt(key, value).apply();
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }

    public int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public void put(String key, long value) {
        editor.putLong(key, value).apply();
    }

    public long getLong(String key) {
        return getLong(key, -1L);
    }

    public long getLong(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public void put(String key, float value) {
        editor.putFloat(key, value).apply();
    }

    public float getFloat(String key) {
        return getFloat(key, -1f);
    }

    public float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    public void put(String key, boolean value) {
        editor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public void put(String key, @Nullable Set<String> values) {
        editor.putStringSet(key, values).apply();
    }

    public Set<String> getStringSet(String key) {
        return getStringSet(key, null);
    }

    public Set<String> getStringSet(String key, @Nullable Set<String> defaultValue) {
        return sp.getStringSet(key, defaultValue);
    }

    public Map<String, ?> getAll() {
        return sp.getAll();
    }

    public void remove(String key) {
        editor.remove(key).apply();
    }

    public boolean contains(String key) {
        return sp.contains(key);
    }

    public void clear() {
        editor.clear().apply();
    }
}