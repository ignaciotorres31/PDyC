package ar.edu.unnoba.pdyc.mymusic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationRequestDTO {

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
