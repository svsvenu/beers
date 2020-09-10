package com.beers.controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.beers.entity.Beer;
import com.beers.repos.BeerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class BeerRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    BeerRepo beerRepo;

    public BeerRestController(){

        log.info("instantiated beer rest controller");
    }




    @GetMapping("/get-beers")
    @ResponseBody
    @CrossOrigin
    public Iterable<Beer> getBeers() {
        beerRepo.save(new Beer());
        log.info("BeerRepo " + beerRepo);
        log.info("Invoked getBeers");
        log.debug("Invoked getBeers");
        log.error("Invoked getBeers");
        log.trace("Invoked getBeers");
        return beerRepo.findAll();

    }

    @GetMapping("/get-beers-by-style")
    @ResponseBody
    @CrossOrigin
    public Iterable<Beer> getBeersByStyle() {


        return beerRepo.findByStyle("lager");
    }



}