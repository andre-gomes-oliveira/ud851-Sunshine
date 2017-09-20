/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.sunshine.utilities.SunshineWeatherUtils;

public class MainActivity extends AppCompatActivity {

    // COMPLETED (1) Create a field to store the weather display TextView
    TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        // COMPLETED (2) Use findViewById to get a reference to the weather display TextView
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        // COMPLETED (3) Create an array of Strings that contain fake weather data
        String[] weatherData = {
                "Today, September 20th - Clear - 17°C / 15°C",
                "Tomorrow - Cloudy - 19°C / 15°C",
                "Friday - Rainy- 30°C / 11°C",
                "Saturday - Thunderstorms - 21°C / 9°C",
                "Sunday - Thunderstorms - 16°C / 7°C",
                "Monday - Rainy - 16°C / 8°C",
                "Tuesday - Partly Cloudy - 15°C / 10°C",
                "Wed, May 24 - Meatballs - 16°C / 18°C",
                "Thu, May 25 - Cloudy - 19°C / 15°C",
                "Fri, May 26 - Stormy - 30°C / 11°C",
                "Sat, May 27 - Hurricane - 21°C / 9°C",
                "Sun, May 28 - Meteors - 16°C / 7°C",
                "Mon, May 29 - Apocalypse - 16°C / 8°C",
                "Tue, May 30 - Post Apocalypse - 15°C / 10°C",
        };

        // COMPLETED (4) Append each String from the fake weather data array to the TextView
        for (String weather : weatherData)
            mWeatherTextView.append(weather + "\n\n\n");
    }
}