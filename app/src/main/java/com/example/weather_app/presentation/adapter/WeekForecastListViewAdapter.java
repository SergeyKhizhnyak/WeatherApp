package com.example.weather_app.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather_app.data.model.DayForecast;
import com.example.weather_app.R;

import java.util.ArrayList;

public class WeekForecastListViewAdapter extends ArrayAdapter<DayForecast> {
    public WeekForecastListViewAdapter(Context context, ArrayList<DayForecast> weekForecast) {
        super(context, 0, weekForecast);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_week_forecast,
                    parent,
                    false);
        }

        DayForecast dayForecast = getItem(position);
        TextView tvDate = convertView.findViewById(R.id.date);
        TextView tvMinMaxTemp = convertView.findViewById(R.id.min_max_temp);
        TextView tvWeatherDescription = convertView.findViewById(R.id.weather_description);
        ImageView ivWeatherIcon = convertView.findViewById(R.id.weather_icon);
        tvDate.setText(dayForecast.getDate());
        tvMinMaxTemp.setText(dayForecast.getMinMaxTemp());
        tvWeatherDescription.setText(dayForecast.getWeatherDescription());
        ivWeatherIcon.setImageDrawable(dayForecast.getWeatherIcon());
        return convertView;
    }
}
