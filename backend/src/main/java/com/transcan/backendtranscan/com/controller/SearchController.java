package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.RideSearch;
import com.transcan.backendtranscan.domain.Role;
import com.transcan.backendtranscan.domain.RoleName;
import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.exception.AppException;
import com.transcan.backendtranscan.payload.ApiResponse;
import com.transcan.backendtranscan.services.RoleService;
import com.transcan.backendtranscan.services.SearchRideService;
import com.transcan.backendtranscan.services.UserInfoService;
import jdk.nashorn.internal.runtime.OptimisticBuiltins;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("/api/search_submit")
public class SearchController {
    private SearchRideService searchRideService;
    private UserInfoService userInfoService;
    private RoleService roleService;

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@Valid @RequestBody RideSearch rideSearch,@Valid @RequestParam Long userId) {

        try {
            UserInfo u = userInfoService.findId(userId).orElse(null);//not working
            if (u != null) {
                rideSearch.setUserInfo(u);
                RideSearch result = searchRideService.save(rideSearch);
                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/api/users/{username}")
                        .buildAndExpand(result.getSearchId()).toUri();
                return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
            }
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "does not exist!"),
                    HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(new ApiResponse(false, "Username does not exist!"),
                HttpStatus.BAD_REQUEST);



    }
    @PostMapping("/submit1")
    public ResponseEntity<?> submit1(@Valid @RequestParam Long userId) {

        Role r = roleService.findById(userId).orElse(null);

        return new ResponseEntity(new ApiResponse(false, "Username does not exist!"),
                HttpStatus.BAD_REQUEST);
    }

}

