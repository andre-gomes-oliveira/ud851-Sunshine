package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by Andre on 30/09/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
{
    private String[] mWeatherData;

    public ForecastAdapter()
    {

    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null)
            return 0;
        else
            return mWeatherData.length;
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        boolean shouldAttachToParentImmediately = false;
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText("Item #" + Integer.toString(position));
    }

    public void  setWeatherData(String[] weatherData)
    {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView mWeatherTextView = null;

        public ForecastAdapterViewHolder (View view)
        {
            super(view);
            view.findViewById(R.id.tv_weather_data);
        }
    }

}
