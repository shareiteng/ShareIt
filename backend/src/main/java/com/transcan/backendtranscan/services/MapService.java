package com.transcan.backendtranscan.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.ArrayList;

public class MapService {

    @Autowired
    private SearchRideService searchRideService;

    public static String getGeolocation(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDCv8LRiSPWaEvGcRELhW1dOnbEYn92a0A")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                address).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return (results[0].geometry.location.toString());
    }

    public static String convertAddressToLatLng(String latLng) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDCv8LRiSPWaEvGcRELhW1dOnbEYn92a0A")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                latLng).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return (results[0].formattedAddress);
    }


    public static float getDistanceGeoLocation(String latLng1, String latLng2) {

        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(getLat(latLng2) - getLat(latLng1));
        double dLng = Math.toRadians(getLng(latLng2) - getLng(latLng1));
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(getLat(latLng1))) * Math.cos(Math.toRadians(getLat(latLng2))) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);

        return dist;

    }

    public static double getLng(String latLng) {
        return Double.parseDouble(latLng.substring(12));
    }

    public static double getLat(String latLng) {
        return Double.parseDouble(latLng.substring(0, 11));
    }

    public String getMiddlePoint(ArrayList<Long> idList, boolean isLocationPoint) {
        double latSum = 0;
        double lngSum = 0;

            for (int i = 0; i < idList.size(); i++) {
                double lat, lng;
                if (isLocationPoint) {
                     lat = getLat(searchRideService.findById(idList.get(i)).orElse(null).getLocLatLng());
                     lng = getLng(searchRideService.findById(idList.get(i)).orElse(null).getLocLatLng());
                } else {
                     lat = getLat(searchRideService.findById(idList.get(i)).orElse(null).getDesLatLng());
                     lng = getLng(searchRideService.findById(idList.get(i)).orElse(null).getDesLatLng());
                }
                latSum +=lat;
                lngSum += lng;
            }

        latSum = latSum / idList.size();
        lngSum = lngSum / idList.size();

        return latSum + "," + lngSum;
    }
}


