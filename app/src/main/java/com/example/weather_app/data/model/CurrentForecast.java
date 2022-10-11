package com.example.weather_app.data.model;

import android.content.Context;

import com.example.weather_app.data.location.LocationTracker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class CurrentForecast {
    private final JSONObject response;

    public CurrentForecast(JSONObject response) {
        this.response = response;
    }

    public int getWeatherCode() throws JSONException {
        JSONObject currentWeather = response.getJSONObject("current_weather");
        return currentWeather.getInt("weathercode");
    }

    public String getCityName(Context context) throws JSONException {
        double latitude = response.getDouble("latitude");
        double longitude = response.getDouble("longitude");
        return Objects.requireNonNull(LocationTracker.getCityName(context, latitude, longitude));
    }

    public String getTemp() throws JSONException {
        JSONObject currentWeather = response.getJSONObject("current_weather");
        return currentWeather.getString("temperature");
    }

    public String getWindSpeed() throws JSONException {
        JSONObject currentWeather = response.getJSONObject("current_weather");
        return currentWeather.getString("windspeed");
    }

    public String getPressure() throws JSONException {
        Integer position = getPosition();

        if (position == null) {
            throw new NullPointerException();
        }

        JSONObject hourly = response.getJSONObject("hourly");
        JSONArray pressure = hourly.getJSONArray("pressure_msl");
        return pressure.getString(position);
    }

    public String getHumidity() throws JSONException {
        Integer position = getPosition();

        if (position == null) {
            throw new NullPointerException();
        }

        JSONObject hourly = response.getJSONObject("hourly");
        JSONArray humidity = hourly.getJSONArray("relativehumidity_2m");
        return humidity.getString(position);
    }

    private Integer getPosition() throws JSONException {
        JSONObject currentWeather = response.getJSONObject("current_weather");
        String currentTime = currentWeather.getString("time");
        JSONObject hourly = response.getJSONObject("hourly");
        JSONArray weekForecastTime = hourly.getJSONArray("time");

        for (int i = 0; i < weekForecastTime.length(); i++) {
            String time = weekForecastTime.getString(i);

            if (currentTime.equals(time)) {
                return i;
            }
        }

        return null;
    }
}
