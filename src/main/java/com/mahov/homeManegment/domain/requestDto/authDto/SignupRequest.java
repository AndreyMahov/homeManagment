package com.mahov.homeManegment.domain.requestDto.authDto;

import lombok.Getter;
import lombok.Setter;


public class SignupRequest {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public SignupRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
