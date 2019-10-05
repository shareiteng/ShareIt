package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.domain.Role;
import com.transcan.backendtranscan.domain.RoleName;
import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.exception.AppException;
import com.transcan.backendtranscan.payload.ApiResponse;
import com.transcan.backendtranscan.services.SearchRideService;
import com.transcan.backendtranscan.services.UserInfoService;
import jdk.nashorn.internal.runtime.OptimisticBuiltins;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;


@RestController
@RequestMapping("/api/search_submit")
public class SearchController {
    private SearchRideService searchRideService;
    private UserInfoService userInfoService;
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@Valid @RequestBody RideSearch rideSearch,@Valid @RequestParam Long userId) {
        if(!userInfoService.existsById(userId)) {
            return new ResponseEntity(new ApiResponse(false, "Username does not exist!"),
                    HttpStatus.BAD_REQUEST);
        }

        RideSearch result =userInfoService.findById(userId).map(users -> {
            rideSearch.setUserInfo(users);
            return searchRideService.save(rideSearch);});
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getSearchId()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

        }).orElseThrow(() -> new AppException("User ID " + userId + " not found"));
    }

    }
}

