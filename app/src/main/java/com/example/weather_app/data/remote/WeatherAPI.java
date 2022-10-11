package com.example.weather_app.data.remote;

import com.loopj.android.http.RequestParams;

public class WeatherAPI {
    private static final String[] HOURLY_PARAMS = new String[]{
            "temperature_2m",
            "pressure_msl",
            "weathercode",
            "windspeed_10m",
            "relativehumidity_2m"};
    private static final String[] DAILY_PARAMS = new String[]{
            "temperature_2m_max",
            "temperature_2m_min",
            "weathercode"};

    public static final String URL = "https://api.open-meteo.com/v1/forecast";

    public static RequestParams setRequestParams(double latitude, double longitude) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("latitude", latitude);
        requestParams.put("longitude", longitude);
        requestParams.put("timezone", "auto");
        requestParams.put("current_weather", "true");
        requestParams.put("hourly", HOURLY_PARAMS);
        requestParams.put("daily", DAILY_PARAMS);
        return requestParams;
    }
}
