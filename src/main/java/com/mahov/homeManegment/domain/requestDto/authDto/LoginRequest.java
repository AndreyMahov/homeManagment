package com.mahov.homeManegment.domain.requestDto.authDto;

import lombok.Getter;
import lombok.Setter;


public class LoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
