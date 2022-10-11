package com.example.weather_app.data.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.weather_app.data.model.Weather;
import com.example.weather_app.data.model.HourForecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class TodayForecast {
    private final JSONObject response;

    public TodayForecast(JSONObject response) {
        this.response = response;
    }

    public ArrayList<HourForecast> getTodayForecast(Context context) throws JSONException {
        ArrayList<HourForecast> todayForecast = new ArrayList<>();
        JSONObject daily = response.getJSONObject("daily");
        JSONArray jaDate = daily.getJSONArray("time");
        JSONObject hourly = response.getJSONObject("hourly");
        JSONArray jaTime = hourly.getJSONArray("time");
        JSONArray jaWeatherCode = hourly.getJSONArray("weathercode");
        JSONArray jaTemp = hourly.getJSONArray("temperature_2m");
        JSONArray jaPressure = hourly.getJSONArray("pressure_msl");
        JSONArray jaHumidity = hourly.getJSONArray("relativehumidity_2m");
        JSONArray jaWindSpeed = hourly.getJSONArray("windspeed_10m");
        String currentDate = jaDate.getString(0);

        for (int i = 0; i < jaTime.length(); i++) {
            String time = jaTime.getString(i);

            if (time.contains(currentDate)) {
                int weatherCode = jaWeatherCode.getInt(i);
                Weather weather = Objects.requireNonNull(WeatherDefiner.getWeather(
                        context, weatherCode));
                Drawable weatherIcon = weather.getIcon();
                String weatherDescription = weather.getDescription();
                String temp = jaTemp.getString(i) + "°C";
                String pressure = jaPressure.getString(i) + "hPa";
                String humidity = jaHumidity.getString(i) + "%";
                String windSpeed = jaWindSpeed.getString(i) + "km/h";
                todayForecast.add(new HourForecast(
                        time,
                        weatherIcon,
                        weatherDescription,
                        temp,
                        pressure,
                        humidity,
                        windSpeed));
            }
        }

        return todayForecast;
    }
}
