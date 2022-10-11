package com.example.weather_app.data.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationTracker {
    public static final double DEFAULT_LATITUDE = 50.450001;
    public static final double DEFAULT_LONGITUDE = 30.523333;

    @SuppressLint("MissingPermission")
    public static void getLastLocation(Context context, OnCompleteListener<Location> listener) {
        FusedLocationProviderClient fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(context);
        fusedLocationClient.getLastLocation().addOnCompleteListener(listener);
    }

    public static String getCityName(Context context, double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

            if (addresses.isEmpty()) {
                return null;
            }

            Address address = addresses.get(0);
            return address.getLocality() + ", " + address.getCountryName();
        } catch (IOException e) {
            return null;
        }
    }
}
