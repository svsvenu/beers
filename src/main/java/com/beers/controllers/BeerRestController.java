package com.beers.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.beers.dao.BeerDao;
import com.beers.dao.BeerDaoImpl;
import com.beers.entity.Beer;
import com.beers.entity.Drinker;
import com.beers.entity.DrinkerBeer;
import com.beers.repos.BeerRepo;
import com.beers.repos.DrinkerRepo;
import com.beers.security.IAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/api/beers")

public class BeerRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    DrinkerRepo drinkerRepo;

    @Autowired
    BeerRepo beerRepo;

    @Autowired
    IAuthentication authentication;


    public BeerRestController(){

        log.info("instantiated beer rest controller");
    }




    @GetMapping("/tasted")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<BeerDao> getBeers() {

        String user =  authentication.getAuthentication().getName();
        log.info ("user is " + user);


        Drinker  drinker = drinkerRepo.findByName(user);

        ArrayList<BeerDao> beerDaoList = new ArrayList<BeerDao>();

        for ( DrinkerBeer drinkerBeer : drinker.getDrinkerBeer()) {

            Beer beer = drinkerBeer.getBeer();

            BeerDaoImpl bd = new BeerDaoImpl() ;
            bd.setAlcoholPercentage(beer.getAlcoholPercentage() + "");
            bd.setBeerName(beer.getBeerName());
            bd.setBrewery(beer.getBrewery().getBreweryName());
            bd.setStyle(beer.getStyle());
            bd.setLiked(drinkerBeer.getId() + "");


            beerDaoList.add(bd);

            }
        return beerDaoList;


    }




    @GetMapping("/all")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<BeerDao> getAllBeersForADrinker() {

        String user =  authentication.getAuthentication().getName();
        log.info ("user is " + user);
        //   beerRepo.save(new Beer());
        //    log.info("BeerRepo " + beerRepo);
        log.info("Invoked getBeers");
        log.debug("Invoked getBeers");
        log.error("Invoked getBeers");
        log.trace("Invoked getBeers");
        return beerRepo.findByNativeQuery(user);

    }

    @GetMapping("/get-beers-by-style")
    @ResponseBody
    @CrossOrigin
    public Iterable<Beer> getBeersByStyle() {


        return drinkerRepo.findByName("venu").getBeer();
    }



}