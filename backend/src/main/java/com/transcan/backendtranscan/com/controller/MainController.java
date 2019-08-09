package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/index")
@CrossOrigin
public class MainController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(path = "/addNewUser")
    public ResponseEntity<?> addNewUser (@Valid @RequestBody UserInfo userInfo, BindingResult result) throws SecurityException {

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
             Iterable<UserInfo> n = userInfoService.findAll();
       // Sec-exception- the email already exist
        SecurityException exception= new SecurityException();
        for (UserInfo u: n){
            if (userInfo.getEmail().equals(u.getEmail()))
               throw exception;
        }
                UserInfo newUser=userInfoService.save(userInfo);
                return new ResponseEntity<UserInfo>(newUser,HttpStatus.CREATED);
            }
    //need to handle exception
    @RequestMapping(path = "/login")
    public @ResponseBody boolean get(@RequestParam String email,@RequestParam String password){
        Iterable<UserInfo> n = userInfoService.findAll();
        for (UserInfo c :n) {
            if(password.equals(c.getPassword())&& email.equals((c.getEmail())))

                return true;
        }
        return false;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<UserInfo> getAllUsers(){
        return userInfoService.findAll();
    }

}
