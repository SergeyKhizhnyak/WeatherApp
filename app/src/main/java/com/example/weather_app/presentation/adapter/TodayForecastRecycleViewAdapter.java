package com.example.weather_app.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.data.model.HourForecast;
import com.example.weather_app.R;

import java.util.ArrayList;

public class TodayForecastRecycleViewAdapter extends RecyclerView.Adapter<TodayForecastRecycleViewAdapter.MyViewHolder> {
    private final ArrayList<HourForecast> todayForecast;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView time;
        private final ImageView weatherIcon;
        private final TextView weatherDescription;
        private final TextView temp;
        private final TextView pressure;
        private final TextView humidity;
        private final TextView windSpeed;

        public MyViewHolder(View view) {
            super(view);
            time = view.findViewById(R.id.time);
            weatherIcon = view.findViewById(R.id.weather_icon);
            weatherDescription = view.findViewById(R.id.weather_description);
            temp = view.findViewById(R.id.temp);
            pressure = view.findViewById(R.id.pressure);
            humidity = view.findViewById(R.id.humidity);
            windSpeed = view.findViewById(R.id.wind_speed);
        }
    }

    public TodayForecastRecycleViewAdapter(ArrayList<HourForecast> todayForecast) {
        this.todayForecast = todayForecast;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_today_forecast, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayForecastRecycleViewAdapter.MyViewHolder holder, int position) {
        HourForecast hourForecast = todayForecast.get(position);
        holder.time.setText(hourForecast.getTime());
        holder.weatherIcon.setImageDrawable(hourForecast.getWeatherIcon());
        holder.weatherDescription.setText(hourForecast.getWeatherDescription());
        holder.temp.setText(hourForecast.getTemp());
        holder.pressure.setText(hourForecast.getPressure());
        holder.humidity.setText(hourForecast.getHumidity());
        holder.windSpeed.setText(hourForecast.getWindSpeed());
    }

    @Override
    public int getItemCount() {
        return todayForecast.size();
    }
}
