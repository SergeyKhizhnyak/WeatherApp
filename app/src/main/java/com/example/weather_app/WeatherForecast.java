package com.example.weather_app;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Headers;

public class WeatherForecast {
    private static final String API_KEY = "63c930937b9ec0b49ee73fa27e1667ad";

    public WeekForecast requestForecast() {
        final WeekForecast[] weekForecast = {null};
        String url = "https://api.openweathermap.org/data/2.5/forecast";
        RequestParams params = new RequestParams();
        params.put("units", "metric");
        params.put("lat", "35");
        params.put("lon", "139");
        params.put("appid", API_KEY);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    JSONArray jsonArray = json.jsonObject.getJSONArray("list");
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    weekForecast[0] = getWeekForecast(jsonArray);
                } catch (JSONException e) {
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });

        return weekForecast[0];
    }

    private WeekForecast getWeekForecast(JSONArray forecasts) throws JSONException {
        HashMap<String, DayForecast> weekForecast = new HashMap<>();
        String date = null;

        for (int i = 0; i < forecasts.length(); i++) {
            JSONObject forecast = (JSONObject) forecasts.get(i);
            String forecastDate = getDateFromResponse(forecast);

            if (!forecastDate.equals(date)) {
                date = forecastDate;
                DayForecast dayForecast = getDayForecast(forecasts, date);
                weekForecast.put(date, dayForecast);
            }
        }

        return new WeekForecast(weekForecast);
    }

    private String getDateFromResponse(JSONObject forecast) throws JSONException {
        String date = forecast.getString("dt_txt");
        return date.split(" ")[0];
    }

    private DayForecast getDayForecast(JSONArray forecasts, String date) throws JSONException {
        List<HourForecast> dayForecast = new ArrayList<>();

        for (int i = 0; i < forecasts.length(); i++) {
            JSONObject forecast = (JSONObject) forecasts.get(i);

            if (forecast.toString().contains(date)) {
                HourForecast hourForecast = getHourForecast(forecast);
                dayForecast.add(hourForecast);
            }
        }

        return new DayForecast(dayForecast);
    }

    private HourForecast getHourForecast(JSONObject forecast) throws JSONException {
        String time = forecast.getString("dt_txt");
        time = time.split(" ")[1];
        JSONObject main = forecast.getJSONObject("main");
        String temperature = main.getString("temp");
        String feelsLikeTemperature = main.getString("feels_like");
        String pressure = main.getString("pressure");
        String humidity = main.getString("humidity");
        JSONArray weather = forecast.getJSONArray("weather");
        JSONObject description = weather.getJSONObject(0);
        String weatherDescription = description.getString("description");
        String icon = description.getString("icon");
        JSONObject wind = forecast.getJSONObject("wind");
        String windSpeed = wind.getString("speed");
        return new HourForecast(
                time,
                temperature,
                feelsLikeTemperature,
                pressure,
                humidity,
                weatherDescription,
                icon,
                windSpeed);
    }
}
