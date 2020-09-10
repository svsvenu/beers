package com.beers.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;



public class JwtUtilTest {


    @Test
    public void generateToken() {

        UserDetails details = new User("foo","bar", new ArrayList<>());
        JwtUtil util = new JwtUtil();
        System.out.println(util.generateToken(details));
    }
}
