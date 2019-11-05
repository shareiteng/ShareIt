package com.transcan.backendtranscan.config;


import com.google.maps.errors.ApiException;
import com.transcan.backendtranscan.domain.BestMatch;
import com.transcan.backendtranscan.domain.ResultMatchObj;
import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.domain.RideSuggestion;
import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.MatchService;
import com.transcan.backendtranscan.services.RideSuggestionService;
import com.transcan.backendtranscan.services.SearchRideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


@Component
public class Checker {

    @Autowired
    private SearchRideService searchRideService;
    private RideSuggestionService rideSuggestionService;

    @Autowired
    private MatchService matchService;

    private static final Logger log = LoggerFactory.getLogger(Checker.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException, ApiException, IOException {
         cosomo();
    }

    private void carpoolRide(){
ArrayList<Long> passengersId= new ArrayList<>();

        for(RideSuggestion row: rideSuggestionService.findAll()) {
            LocalDate inputDate = LocalDate.parse(row.getDate());
            LocalTime rowHour = LocalTime.parse(row.getHours());
            log.info("The time is now {}", LocalTime.now());
            if (inputDate.isEqual(LocalDate.now()) && LocalTime.now().isAfter(rowHour.minusMinutes(15))) {
                for (RideSearch searchLine : searchRideService.findAll()) {
                    int freeSeat = row.getSeats();
                    if (freeSeat > 0 && MapService.getDistanceGeoLocation(row.getDesLatLng(), searchLine.getDesLatLng()) <= 500 &&
                            MapService.getDistanceGeoLocation(row.getLocLatLng(), searchLine.getLocLatLng()) <= 500) {
                        passengersId.add(searchLine.getSearchId());
                    }
                }
                matchService.save(new BestMatch(row, passengersId, MapService.getMiddlePoint(passengersId, true, searchRideService), MapService.getMiddlePoint(passengersId, false, searchRideService)));
                for (long id : passengersId) {
                    searchRideService.delete(searchRideService.findById(id).get());
                }
                rideSuggestionService.delete(row);


            }


                }


        }
        public void cosomo() throws InterruptedException, ApiException, IOException {
            long userId = 0;
            for ( int i=0; i< searchRideService.findAll().size();i++) {
               for (RideSearch row : searchRideService.findAll()) {
                   if (userId == 0) {
                       LocalDate inputDate = LocalDate.parse(row.getDate());
                       LocalTime rowHour = LocalTime.parse(row.getHours());
                       log.info("The time is now {}", LocalTime.now());
                       if (inputDate.isEqual(LocalDate.now()) && LocalTime.now().isAfter(rowHour.minusMinutes(15))) {
                           userId = row.getUserInfo().getId();

                       }}
                   }} if (userId != 0) {
                   ResultMatchObj obj = new ResultMatchObj(userId);
                   ArrayList<RideSearch> searchId = searchRideService.findUserID(userId);
                   Iterable<RideSearch> entities = searchRideService.findAll();
                   ArrayList<ResultMatchObj> result = obj.getMatchList(entities);
                   ArrayList<ResultMatchObj> result1 = obj.getMatchObjList(result, searchRideService);
                   matchService.save(new BestMatch("1", "2", "3", "4"));
                   ResultMatchObj res = obj.findTheBestRideByUserId(searchId, result1, userId).get(0);
                   for (long id : res.getPassengerID())
                   searchRideService.delete(searchRideService.findUserID(id).get(0));

                for (RideSearch row : searchRideService.findAll()) {
                    if(row.getUserInfo().getId()==userId)
                        searchRideService.delete(row);
               }
                userId=0;
           }
        }}
