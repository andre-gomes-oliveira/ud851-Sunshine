package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mForecastDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mForecastDetail = (TextView) findViewById(R.id.tv_forecast_detail);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        Intent staterIntent = getIntent();
        if(staterIntent.hasExtra(Intent.EXTRA_TEXT)) {
        }
            mForecastDetail.setText(staterIntent.getStringExtra(Intent.EXTRA_TEXT));
      }
}