package com.transcan.backendtranscan.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

public class MapService {

    public static LatLng getGeolocation(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDCv8LRiSPWaEvGcRELhW1dOnbEYn92a0A")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                "מאיר שפיה 9, פתח תקווה").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return(results[0].geometry.location);
    }

    public static void getDistanceGeolocation(){

    }



}