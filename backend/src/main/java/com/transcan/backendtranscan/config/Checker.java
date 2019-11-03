package com.transcan.backendtranscan.config;


import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.services.MatchService;
import com.transcan.backendtranscan.services.SearchRideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Component
public class Checker {

    @Autowired
    private SearchRideService searchRideService;

    @Autowired
    private MatchService matchService;

    private static final Logger log = LoggerFactory.getLogger(Checker.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 50000)
    public void reportCurrentTime() {
        for (RideSearch row : searchRideService.findAll()) {

            LocalDate inputDate = LocalDate.parse(row.getDate());
            LocalTime a=LocalTime.parse(row.getHours());
            if(inputDate.isEqual(LocalDate.now())&& LocalTime.now().isAfter(a.minusMinutes(15)));
            matchService.save(row);
            searchRideService.delete(row);

        }
    }
}

