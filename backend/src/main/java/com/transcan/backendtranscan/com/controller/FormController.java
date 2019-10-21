package com.transcan.backendtranscan.com.controller;

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
            rideSearch.setLocLatLng(MapService.getGeolocation(rideSearch.getLocation()).toString());
            rideSearch.setDesLatLng(MapService.getGeolocation(rideSearch.getDesination()).toString());
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
            return new ResponseEntity(new ApiResponse(false, "user does not exist!"),
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
}

