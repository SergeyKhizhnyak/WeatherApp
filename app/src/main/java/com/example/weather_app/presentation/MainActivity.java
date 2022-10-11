package com.example.weather_app.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weather_app.data.model.DayForecast;
import com.example.weather_app.data.model.HourForecast;
import com.example.weather_app.gestures.OnSwipeTouchListener;
import com.example.weather_app.R;
import com.example.weather_app.presentation.adapter.TodayForecastRecycleViewAdapter;
import com.example.weather_app.presentation.adapter.WeekForecastListViewAdapter;
import com.example.weather_app.controler.Contract;
import com.example.weather_app.data.handler.ResponseHandler;
import com.example.weather_app.data.remote.RequestHandler;
import com.example.weather_app.utils.PermissionUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private static final String PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final int REQUEST_CODE = 1010;

    private ViewGroup rootLayout;
    private CardView currentForecastShort;
    private CardView currentForecastFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.root_layout);
        currentForecastShort = findViewById(R.id.current_forecast_short);
        currentForecastFull = findViewById(R.id.current_forecast_full);
        PermissionUtils.requestPermission(this, this, PERMISSION, REQUEST_CODE);
        ResponseHandler responseHandler = new ResponseHandler(new RequestHandler(), this);
        responseHandler.processResponse(this);
        onSwipeUp(currentForecastFull);
        onSwipeDown(currentForecastShort);
    }

    @Override
    public void fillCurrentForecastShort(Drawable weatherIcon, String cityName, String temp) {
        ImageView weatherIconIV = findViewById(R.id.weather_icon_short);
        TextView cityNameTV = findViewById(R.id.city_name_short);
        TextView tempTV = findViewById(R.id.temp_short);
        weatherIconIV.setImageDrawable(weatherIcon);
        cityNameTV.setText(cityName);
        tempTV.setText(temp);
    }

    @Override
    public void fillCurrentForecastFull(
            String cityName,
            Drawable weatherIcon,
            String weatherDescription,
            String temp,
            String pressure,
            String humidity,
            String windSpeed) {
        TextView cityNameTV = findViewById(R.id.city_name_full);
        ImageView weatherIconIV = findViewById(R.id.weather_icon_full);
        TextView weatherDescriptionTV = findViewById(R.id.weather_description_full);
        TextView tempTV = findViewById(R.id.temp_full);
        TextView pressureTV = findViewById(R.id.pressure_full);
        TextView humidityTV = findViewById(R.id.humidity_full);
        TextView windSpeedTV = findViewById(R.id.wind_speed_full);
        cityNameTV.setText(cityName);
        weatherIconIV.setImageDrawable(weatherIcon);
        weatherDescriptionTV.setText(weatherDescription);
        tempTV.setText(temp);
        pressureTV.setText(pressure);
        humidityTV.setText(humidity);
        windSpeedTV.setText(windSpeed);
    }

    @Override
    public void fillTodayForecast(ArrayList<HourForecast> todayForecast) {
        RecyclerView recyclerView = findViewById(R.id.today_forecast);
        TodayForecastRecycleViewAdapter adapter = new TodayForecastRecycleViewAdapter(todayForecast);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fillWeekForecast(ArrayList<DayForecast> weekForecast) {
        WeekForecastListViewAdapter adapter = new WeekForecastListViewAdapter(
                this,
                weekForecast);
        ListView listView = findViewById(R.id.week_forecast);
        listView.setAdapter(adapter);
    }

    private void onSwipeUp(View view) {
        view.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                TransitionManager.beginDelayedTransition(rootLayout);
                Transition slideTop = new Slide(Gravity.TOP);
                slideTop.addTarget(currentForecastFull);
                currentForecastFull.setVisibility(View.GONE);
                Transition slideBottom = new Slide(Gravity.BOTTOM);
                slideBottom.addTarget(currentForecastShort);
                currentForecastShort.setVisibility(View.VISIBLE);
            }
        });
    }

    private void onSwipeDown(View view) {
        view.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                TransitionManager.beginDelayedTransition(rootLayout);
                Transition slideTop = new Slide(Gravity.TOP);
                slideTop.addTarget(currentForecastShort);
                currentForecastShort.setVisibility(View.GONE);
                Transition slideBottom = new Slide(Gravity.BOTTOM);
                slideBottom.addTarget(currentForecastFull);
                currentForecastFull.setVisibility(View.VISIBLE);
            }
        });
    }
}
