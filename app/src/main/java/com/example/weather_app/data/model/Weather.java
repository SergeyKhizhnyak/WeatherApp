package com.example.weather_app.data.model;

import android.graphics.drawable.Drawable;

public class Weather {
    private final Drawable weatherIcon;
    private final String weatherDescription;

    public Weather(Drawable weatherIcon, String weatherDescription) {
        this.weatherIcon = weatherIcon;
        this.weatherDescription = weatherDescription;
    }

    public Drawable getIcon() {
        return weatherIcon;
    }

    public String getDescription() {
        return weatherDescription;
    }
}
