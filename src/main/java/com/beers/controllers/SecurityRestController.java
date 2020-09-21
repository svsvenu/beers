package com.beers.controllers;

import com.beers.security.AuthenticationRequest;
import com.beers.security.AuthenticationResponse;
import com.beers.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class SecurityRestController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping ("/authenticate")
    @ResponseBody
    @CrossOrigin
    public AuthenticationResponse getToken(@RequestBody AuthenticationRequest request) {

        AuthenticationResponse response = new AuthenticationResponse();
        try{
        log.info("request is " + request.getUserName());



        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        if ( request.getPassword()!= null && !request.getPassword().equalsIgnoreCase(userDetails.getPassword())) {
            return response;
        }

        if ( userDetails == null){
            log.info("User details is null");
        }

        response.setJwt(jwtUtil.generateToken(userDetails));}
        catch (Exception ex){
            log.error("excetpion",ex);
        }
        return  response;

    }

}
