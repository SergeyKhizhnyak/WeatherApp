package com.example.weather_app.data.handler;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.weather_app.R;
import com.example.weather_app.data.model.Weather;

public class WeatherDefiner {
    public static Weather getWeather(Context context, int weatherCode) {
        switch (weatherCode) {
            case 0:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_clear_sky),
                        "Clear sky");
            case 1:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_mainly_clear),
                        "Mainly clear");
            case 2:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_partly_cloudy),
                        "Partly cloudy");
            case 3:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_overcast),
                        "Overcast");
            case 45:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_partly_cloudy),
                        "Fog");
            case 48:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_overcast),
                        "Depositing rime fog");
            case 51:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_light_drizzle),
                        "Light drizzle");
            case 53:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_moderate_drizzle),
                        "Moderate drizzle");
            case 55:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_dense_intensity_drizzle),
                        "Dense intensity drizzle");
            case 56:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_freezing_drizzle),
                        "Freezing drizzle");
            case 57:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_freezing_drizzle),
                        "Dense intensity freezing drizzle");
            case 61:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_light_drizzle),
                        "Slight rain");
            case 63:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_moderate_drizzle),
                        "Moderate rain");
            case 65:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_dense_intensity_drizzle),
                        "Heavy intensity rain");
            case 66:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_freezing_drizzle),
                        "Light freezing rain");
            case 67:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_freezing_drizzle),
                        "Heavy intensity freezing rain");
            case 71:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_snowy),
                        "Slight snow fall");
            case 73:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_snowy),
                        "Moderate snow fall");
            case 75:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_heavy_snow),
                        "Heavy intensity snow fall");
            case 77:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_heavy_snow),
                        "Snow grains");
            case 80:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_light_drizzle),
                        "Slight rain showers");
            case 81:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_moderate_drizzle),
                        "Moderate rain showers");
            case 82:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_dense_intensity_drizzle),
                        "Violent rain showers");
            case 85:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_snowy),
                        "Slight snow showers");
            case 86:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_heavy_snow),
                        "Heavy snow showers");
            case 95:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_thunder),
                        "Thunderstorm");
            case 96:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_dense_intensity_drizzle),
                        "Thunderstorm with slight hail");
            case 99:
                return new Weather(
                        ContextCompat.getDrawable(context, R.drawable.ic_dense_intensity_drizzle),
                        "Thunderstorm with slight hail");
            default:
                return null;
        }
    }
}
