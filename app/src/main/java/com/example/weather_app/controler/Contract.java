package com.example.weather_app.controler;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.weather_app.data.model.DayForecast;
import com.example.weather_app.data.model.HourForecast;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.util.ArrayList;

public interface Contract {
    interface Model {
        void performRequest(Context context, JsonHttpResponseHandler listener);
    }

    interface View {
        void fillCurrentForecastShort(Drawable weatherIcon, String cityName, String temp);

        void fillCurrentForecastFull(
                String cityName,
                Drawable weatherIcon,
                String weatherDescription,
                String temp,
                String pressure,
                String humidity,
                String windSpeed);

        void fillTodayForecast(ArrayList<HourForecast> todayForecast);

        void fillWeekForecast(ArrayList<DayForecast> weekForecast);
    }

    interface Presenter {
        void processResponse(Context context);
    }
}
