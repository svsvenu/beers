package com.beers.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String userName;
    private String password;
}
