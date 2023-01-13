package com.mahov.homeManegment.controllers.impl;


import com.mahov.homeManegment.controllers.AuthController;
import com.mahov.homeManegment.domain.requestDto.authDto.LoginRequest;
import com.mahov.homeManegment.domain.requestDto.authDto.SignupRequest;
import com.mahov.homeManegment.services.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authUser(loginRequest));
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        return authService.registerUser(signupRequest);
    }
}
