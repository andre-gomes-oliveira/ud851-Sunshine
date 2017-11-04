package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

//  COMPLETED (1) Create a class called SunshineSyncTask
//  COMPLETED (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      COMPLETED (3) Within syncWeather, fetch new weather data
//      COMPLETED (4) If we have valid results, delete the old data and insert the new
public class SunshineSyncTask {
    private final static String TAG = SunshineSyncTask.class.getSimpleName();

    synchronized public static void  syncWeather (Context context){
        try {
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            ContentValues[] weatherValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);

            if(weatherValues != null && weatherValues.length > 0){
                ContentResolver resolver = context.getContentResolver();

                resolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null);

                resolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherValues);
            }
        }
        catch (JSONException e) {
            Log.e(TAG, "syncWeather: There are problems with the JSON file.", e);
        } catch (IOException e) {
            Log.e(TAG, "syncWeather: IO error.", e);
        }
    }
}