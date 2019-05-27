package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path = "/index")
public class MainController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(path = "/add")
    public @ResponseBody boolean addNewUser (@RequestParam String username, @RequestParam String email , @RequestParam String password) {
        UserInfo n = new UserInfo();
        n.setUsername(username);
        n.setEmail(email);
        n.setPassword(password);
        userInfoService.save(n);
        return true;
    }

    @RequestMapping(path = "/get")
    public @ResponseBody boolean get(@RequestParam String username,@RequestParam String password){

        List<UserInfo> n = userInfoService.findByUsername(username);
        for (UserInfo c:n) {
            if(password.equals(c.getPassword()))return true;
        }
        return false;


    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<UserInfo> getAllUsers(){
        return userInfoService.findAll();
    }

}
