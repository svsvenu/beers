package com.beers.security;

import org.springframework.security.core.Authentication;

public interface IAuthentication {

    Authentication getAuthentication();
}
