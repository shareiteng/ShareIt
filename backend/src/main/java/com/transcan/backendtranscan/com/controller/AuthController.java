package com.transcan.backendtranscan.com.controller;

import com.transcan.backendtranscan.domain.Role;
import com.transcan.backendtranscan.domain.RoleName;
import com.transcan.backendtranscan.domain.UserInfo;
import com.transcan.backendtranscan.exception.AppException;
import com.transcan.backendtranscan.payload.ApiResponse;
import com.transcan.backendtranscan.payload.JwtAuthenticationResponse;
import com.transcan.backendtranscan.payload.LoginRequest;
import com.transcan.backendtranscan.payload.SignUpRequest;
import com.transcan.backendtranscan.security.JwtTokenProvider;
import com.transcan.backendtranscan.services.RoleService;
import com.transcan.backendtranscan.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    RoleService roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/islogin")
    public ResponseEntity<?> isLogin( @Valid @RequestBody String  loginRequest) {
         boolean isLogged=tokenProvider.validateToken(loginRequest);
        return ResponseEntity.ok(isLogged);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        System.out.println(signUpRequest.toString()+"sss");
        if(userInfoService.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userInfoService.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        UserInfo user = new UserInfo(signUpRequest.getUsername(),signUpRequest.getEmail(),
                signUpRequest.getPassword(),signUpRequest.getFirstname(),signUpRequest.getLastname());


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        UserInfo result = userInfoService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

}
