package com.example.weather_app;

import java.util.List;

public class DayForecast {
    private final List<HourForecast> dayForecast;

    public DayForecast(List<HourForecast> dayForecast) {
        this.dayForecast = dayForecast;
    }

    public List<HourForecast> getDayForecast() {
        return dayForecast;
    }

    public String getMinTemperature() {
        return null;
    }

    public String getMaxTemperature() {
        return null;
    }

    public String getCurrentTemperature() {
        return null;
    }

    public String getCurrentFeelsLikeTemperature() {
        return null;
    }

    public String getCurrentPressure() {
        return null;
    }

    public String getCurrentHumidity() {
        return null;
    }

    public String getCurrentWeather() {
        return null;
    }

    public String getCurrentWeatherDescription() {
        return null;
    }
}
