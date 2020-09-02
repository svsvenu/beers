package com.beers.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.beers.dao.BeerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class BeerRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public BeerRestController(){

        log.info("instantiated beer rest controller");
    }


    @GetMapping("/get-beers")
    @ResponseBody
    public BeerDao getBeers() {
        log.info("Invoked getBeers");
        log.debug("Invoked getBeers");
        log.error("Invoked getBeers");
        log.trace("Invoked getBeers");
        return new BeerDao();
    }

}