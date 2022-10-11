package com.example.weather_app.data.model;

import android.graphics.drawable.Drawable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DayForecast {
    private final String date;
    private final String minMaxTemp;
    private final String weatherDescription;
    private final Drawable weatherIcon;

    public DayForecast(
            String date,
            String minMaxTemp,
            String weatherDescription,
            Drawable weatherIcon) {
        this.date = date;
        this.minMaxTemp = minMaxTemp;
        this.weatherDescription = weatherDescription;
        this.weatherIcon = weatherIcon;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd",
                Locale.ENGLISH);
        Date date = null;

        try {
            date = simpleDateFormat.parse(this.date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        simpleDateFormat = new SimpleDateFormat("EE.", Locale.ENGLISH);
        return simpleDateFormat.format(Objects.requireNonNull(date));
    }

    public String getMinMaxTemp() {
        return minMaxTemp;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public Drawable getWeatherIcon() {
        return weatherIcon;
    }
}
