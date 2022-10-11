package com.example.weather_app.data.model;

import android.graphics.drawable.Drawable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HourForecast {
    private final String time;
    private final Drawable weatherIcon;
    private final String weatherDescription;
    private final String temp;
    private final String pressure;
    private final String humidity;
    private final String windSpeed;

    public HourForecast(
            String time,
            Drawable weatherIcon,
            String weatherDescription,
            String temp,
            String pressure,
            String humidity,
            String windSpeed) {
        this.time = time;
        this.weatherIcon = weatherIcon;
        this.weatherDescription = weatherDescription;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        return localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public Drawable getWeatherIcon() {
        return weatherIcon;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }
}
