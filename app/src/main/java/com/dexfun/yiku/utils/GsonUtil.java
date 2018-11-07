package com.dexfun.yiku.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Smile on 17/5/26.
 */

public class GsonUtil {

    private static final String TAG = GsonUtil.class.getSimpleName();

    private GsonUtil() {
    }

    private static class init {
        static Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullValueToEmptyAdapterFactory()).create();
    }

    public static Gson create() {
        return init.gson;
    }

    private static class NullValueToEmptyAdapterFactory implements TypeAdapterFactory {

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<? super T> rawType = type.getRawType();
            if (rawType == String.class) {
                return (TypeAdapter<T>) new StringNullAdapter();
            }
            return null;
        }
    }

    private static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
//                Log.e(TAG, "has a null value! ".concat(reader.toString()));
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
