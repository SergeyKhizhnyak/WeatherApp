package com.example.weather_app;

import java.util.HashMap;

public class WeekForecast {
    private final HashMap<String, DayForecast> weekForecast;

    public WeekForecast(HashMap<String, DayForecast> weekForecast) {
        this.weekForecast = weekForecast;
    }

    public HashMap<String, DayForecast> getWeekForecast() {
        return weekForecast;
    }
}
