package com.transcan.backendtranscan;

import com.google.maps.errors.ApiException;
import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.SearchRideService;
import com.transcan.backendtranscan.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication

@EntityScan(basePackageClasses = {
        BackendtranscanApplication.class,
        Jsr310JpaConverters.class
})
@EnableScheduling
public class BackendtranscanApplication {
    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    @Autowired
    private SearchRideService searchRideService;
    @Autowired
    private UserInfoService userInfoService;


    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        SpringApplication.run(BackendtranscanApplication.class, args);
        System.out.println(MapService.getGeolocation("מאיר שפיה 9, פתח תקווה"));
        System.out.println(MapService.convertAddressToLatLng("32.10164030,34.87328770"));
        System.out.println(MapService.convertAddressToLatLng("32.10194030,34.87388770"));
        System.out.println(MapService.getDistanceGeoLocation("32.10164030,34.87328770","32.10194030,34.87388770"));





    }
}


