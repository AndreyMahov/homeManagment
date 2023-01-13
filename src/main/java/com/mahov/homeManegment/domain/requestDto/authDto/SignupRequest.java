package com.mahov.homeManegment.domain.requestDto.authDto;

public class SignupRequest {

    private final String login;
    private final String password;

    public SignupRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
