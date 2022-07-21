package com.example.weather_app;

public class HourForecast {
    private final String time;
    private final String temperature;
    private final String feelsLikeTemperature;
    private final String pressure;
    private final String humidity;
    private final String weatherDescription;
    private final String icon;
    private final String windSpeed;

    public HourForecast(
            String time,
            String temperature,
            String feelsLikeTemperature,
            String pressure,
            String humidity,
            String weatherDescription,
            String icon,
            String windSpeed) {
        this.time = time;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getIcon() {
        return icon;
    }

    public String getWindSpeed() {
        return windSpeed;
    }
}
