package com.mahov.homeManegment.controllers;


import com.mahov.homeManegment.domain.requestDto.authDto.LoginRequest;
import com.mahov.homeManegment.domain.requestDto.authDto.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    @PostMapping("/signin")
    ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest);


    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest);
}
