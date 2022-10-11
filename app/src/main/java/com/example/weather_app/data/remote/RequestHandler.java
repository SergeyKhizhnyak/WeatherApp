package com.example.weather_app.data.remote;

import android.content.Context;

import com.example.weather_app.controler.Contract;
import com.example.weather_app.data.location.LocationTracker;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class RequestHandler implements Contract.Model {

    @Override
    public void performRequest(Context context, JsonHttpResponseHandler listener) {
        LocationTracker.getLastLocation(context, task -> task.addOnSuccessListener(location -> {
            double latitude;
            double longitude;

            if (location == null) {
                latitude = LocationTracker.DEFAULT_LATITUDE;
                longitude = LocationTracker.DEFAULT_LONGITUDE;
            } else {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }

            RequestParams requestParams = WeatherAPI.setRequestParams(latitude, longitude);
            AsyncHttpClient client = new AsyncHttpClient();
            client.get(WeatherAPI.URL, requestParams, listener);
        }));
    }
}
