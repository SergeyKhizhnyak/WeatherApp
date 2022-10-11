package com.example.weather_app.data.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.weather_app.data.model.Weather;
import com.example.weather_app.data.model.DayForecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class WeekForecast {
    private final JSONObject response;

    public WeekForecast(JSONObject response) {
        this.response = response;
    }

    public ArrayList<DayForecast> getWeekForecast(Context context) throws JSONException {
        JSONObject daily = response.getJSONObject("daily");
        JSONArray weekDates = daily.getJSONArray("time");
        JSONArray weekMinTemps = daily.getJSONArray("temperature_2m_min");
        JSONArray weekMaxTemps = daily.getJSONArray("temperature_2m_max");
        JSONArray weekWeatherCodes = daily.getJSONArray("weathercode");
        ArrayList<DayForecast> weekForecast = new ArrayList<>();

        for (int i = 0; i < weekDates.length(); i++) {
            String date = weekDates.getString(i);
            String minTemp = weekMinTemps.getString(i);
            String maxTemp = weekMaxTemps.getString(i);
            String minMaxTemp = minTemp + "° / " + maxTemp + "°";
            int weatherCode = weekWeatherCodes.getInt(i);
            Weather weather = Objects.requireNonNull(WeatherDefiner.getWeather(context, weatherCode));
            String weatherDescription = weather.getDescription();
            Drawable weatherIcon = weather.getIcon();
            weekForecast.add(new DayForecast(
                    date,
                    minMaxTemp,
                    weatherDescription,
                    weatherIcon));
        }

        return weekForecast;
    }
}
