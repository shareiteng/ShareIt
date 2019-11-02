package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.ResultMatchObj;
import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.domain.RideSuggestion;
import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.payload.ApiResponse;
import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.RideSuggestionService;
import com.transcan.backendtranscan.services.SearchRideService;
import com.transcan.backendtranscan.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimerTask;

@CrossOrigin
@RestController
@RequestMapping("/api/form_submit")
public class FormController {
    @Autowired
    private SearchRideService searchRideService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RideSuggestionService rideSuggestionService;


    @PostMapping("/searchsubmit")
    public ResponseEntity<?> searchSubmit(@Valid @RequestBody RideSearch rideSearch,@Valid @RequestParam Long userId) {

        try {
            rideSearch.setHours(rideSearch.getDate().substring(11));
            rideSearch.setDate(rideSearch.getDate().substring(0,10));
            rideSearch.setLocLatLng(MapService.getGeolocation(rideSearch.getLocation()));
            rideSearch.setDesLatLng(MapService.getGeolocation(rideSearch.getDestination()));
            UserInfo u = userInfoService.findById(userId).orElse(null);
            if (u != null) {
                rideSearch.setUserInfo(u);
                RideSearch result = searchRideService.save(rideSearch);
                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/api/users/{username}")
                        .buildAndExpand(result.getSearchId()).toUri();
                return ResponseEntity.created(location).body(new ApiResponse(true, "ride search registered successfully"+ rideSearch.getDate()+"aaaaa"+rideSearch.getHours()));
            }
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "user does not exist!     " +e.toString()),
                    HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(new ApiResponse(false, "something went wrong please try again"),
                HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/suggestionsubmit")
    public ResponseEntity<?> suggestionSubmit(@Valid @RequestBody RideSuggestion rideSuggestion, @Valid @RequestParam Long userId) {


        try {
            rideSuggestion.setHours(rideSuggestion.getDate().substring(11));
            rideSuggestion.setDate(rideSuggestion.getDate().substring(0,10));
            UserInfo u = userInfoService.findById(userId).orElse(null);
            if (u != null) {
                rideSuggestion.setUserInfo(u);
                RideSuggestion result = rideSuggestionService.save(rideSuggestion);
                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/api/users/{username}")
                        .buildAndExpand(result.getSuggestionId()).toUri();
                return ResponseEntity.created(location).body(new ApiResponse(true, "ride suggestion registered successfully"));
            }
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "user does not exist!"),
                    HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(new ApiResponse(false, "something went wrong please try again"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/data")
    public void searchSubmit() {
        String desLatLang = "11";
        String loLatLang = "11";

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                for (int h = 0;  h< 9; h++) {
                    desLatLang = "32.10" + j + i + h + "630,34.8" + j + i + h + "7270";
                    loLatLang = "32.102" + j + i + h + "30,34.8" + j + i + h + "4970";


                    System.out.println("1: " + loLatLang + "2: " + desLatLang);
                    RideSearch rideSearch = new RideSearch();
                    rideSearch.setDesLatLng(desLatLang);
                    rideSearch.setLocLatLng(loLatLang);
                    try {

                        rideSearch.setRideSearch(MapService.convertAddressToLatLng(loLatLang), MapService.convertAddressToLatLng(desLatLang), "24.12.19", "14:00");


                        rideSearch.setUserInfo(new UserInfo("username12" + i + h + j, "sajj@dd.com12" + i + h + j, "123", "jjj", "jjj"));

                        searchRideService.save(rideSearch);
                    } catch (Exception e) {
                        System.out.println("server eror" + e.getMessage());
                    }
                }
    }



    @PostMapping("/getbestride")
    public ArrayList<ResultMatchObj> getBestRide(@Valid @RequestParam Long userId) {
        ResultMatchObj obj = new ResultMatchObj(userId);
        Iterable<RideSearch> entities =searchRideService.findAll();
        ArrayList<ResultMatchObj> result = obj.getMatchList(entities);
        return obj.getMatchObjList(result,searchRideService);
    }


    @PostMapping("/getid")
    public ArrayList<ResultMatchObj>  getUser(@Valid @RequestParam  Long userId){
        ResultMatchObj obj = new ResultMatchObj(userId);
        Iterable<RideSearch> entities =searchRideService.findAll();
        return obj.getMatchList(entities);
    }

    @PostMapping("/getstreet")
    public String  getUser(@Valid @RequestParam String lat){
        try{
            return MapService.convertAddressToLatLng(lat);
        }catch (Exception e){
            return "";
        }
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestParam Long userId){
        searchRideService.deleteById(userId);
    }
}
