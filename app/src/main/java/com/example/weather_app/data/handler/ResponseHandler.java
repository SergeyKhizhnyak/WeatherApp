package com.example.weather_app.data.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.weather_app.data.model.Weather;
import com.example.weather_app.controler.Contract;
import com.example.weather_app.data.model.CurrentForecast;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import cz.msebera.android.httpclient.Header;

public class ResponseHandler implements Contract.Presenter {
    private final Contract.Model model;
    private final Contract.View view;

    public ResponseHandler(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void processResponse(Context context) {
        model.performRequest(context, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                CurrentForecast currentForecast = new CurrentForecast(response);
                TodayForecast todayForecast = new TodayForecast(response);
                WeekForecast weekForecast = new WeekForecast(response);

                try {
                    int weatherCode = currentForecast.getWeatherCode();
                    Weather weather = Objects.requireNonNull(
                            WeatherDefiner.getWeather(context, weatherCode));
                    Drawable weatherIcon = weather.getIcon();
                    String weatherDescription = weather.getDescription();
                    String cityName = currentForecast.getCityName(context);
                    String temp = currentForecast.getTemp() + "°C";
                    String pressure = currentForecast.getPressure() + "hPa";
                    String humidity = currentForecast.getHumidity() + "%";
                    String windSpeed = currentForecast.getWindSpeed() + "km/h";
                    view.fillCurrentForecastShort(weatherIcon, cityName, temp);
                    view.fillCurrentForecastFull(
                            cityName,
                            weatherIcon,
                            weatherDescription,
                            temp,
                            pressure,
                            humidity,
                            windSpeed);
                    view.fillTodayForecast(todayForecast.getTodayForecast(context));
                    view.fillWeekForecast(weekForecast.getWeekForecast(context));
                } catch (JSONException | NullPointerException e) {
                    Log.d("exception", e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
