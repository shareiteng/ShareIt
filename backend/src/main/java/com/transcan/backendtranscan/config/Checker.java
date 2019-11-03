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
        for (RideSearch row : searchRideService.findAll()) {

            LocalDate inputDate = LocalDate.parse(row.getDate());
            LocalTime rowHour=LocalTime.parse(row.getHours());
            log.info("The time is now {}", LocalTime.now());
            if(inputDate.isEqual(LocalDate.now())&& LocalTime.now().isAfter(rowHour.minusMinutes(15))){
            /***/
                ResultMatchObj obj = new ResultMatchObj(row.getUserInfo().getId());
                ArrayList<RideSearch> searchId=searchRideService.findUserID(row.getUserInfo().getId());
                Iterable<RideSearch> entities =searchRideService.findAll();
                ArrayList<ResultMatchObj> tempResult = obj.getMatchList(entities);
                ArrayList<ResultMatchObj> result= obj.getMatchObjList(tempResult,searchRideService);
                result=obj.findTheBestRideByUserId(searchId,result,row.getUserInfo().getId());
              /**/
                for(ResultMatchObj resultMatchObj: result){
                    LocalDate resDate = LocalDate.parse(resultMatchObj.getDate());
                    LocalTime resHour=LocalTime.parse(resultMatchObj.getHour());
                    if(resDate.isEqual(LocalDate.now())&& LocalTime.now().isAfter(resHour.minusMinutes(15))){
                        matchService.save(new BestMatch(row, resultMatchObj.getPassngersIdList(), resultMatchObj.getAvargeLatloc(), resultMatchObj.getAvargeLatDes()));
                        for(long id : resultMatchObj.getPassengerList()){
                            searchRideService.delete(searchRideService.findById(id).get());
                    }
                        searchRideService.delete(row);
                    };
            }}

        }
    }

    private void carpoolRide(){
ArrayList<Long> passengersId= new ArrayList<>();

        for(RideSuggestion row: rideSuggestionService.findAll()){
            LocalDate inputDate = LocalDate.parse(row.getDate());
            LocalTime rowHour=LocalTime.parse(row.getHours());
            log.info("The time is now {}", LocalTime.now());
            if(inputDate.isEqual(LocalDate.now())&& LocalTime.now().isAfter(rowHour.minusMinutes(15))) {
                for (RideSearch searchLine : searchRideService.findAll()) {
                    int freeSeat = row.getSeats();
                    if (freeSeat > 0 && MapService.getDistanceGeoLocation(row.getDesLatLng(), searchLine.getDesLatLng()) <= 500 &&
                            MapService.getDistanceGeoLocation(row.getLocLatLng(), searchLine.getLocLatLng()) <= 500) {
                        passengersId.add(searchLine.getSearchId());
                    }
                }
                 matchService.save(new BestMatch(row,passengersId,MapService.getMiddlePoint(passengersId, true, searchRideService),MapService.getMiddlePoint(passengersId, false, searchRideService) ));
                for(long id : passengersId){
                    searchRideService.delete(searchRideService.findById(id).get());
                }
                rideSuggestionService.delete(row);


                }
                }

        }
    }

