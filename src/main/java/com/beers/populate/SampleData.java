package com.beers.populate;

import com.beers.entity.Beer;
import com.beers.entity.Brewery;
import com.beers.entity.Drinker;
import com.beers.repos.BeerRepo;
import com.beers.repos.BreweryRepo;
import com.beers.repos.DrinkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SampleData {

    @Autowired
    DrinkerRepo drinkerRepo;

    @Autowired
    BeerRepo beerRepo;

    @Autowired
    BreweryRepo breweryRepo;

    public SampleData() {





    }

    @PostConstruct
    public void init() {

        Brewery b = new Brewery();
        b.setBreweryName("AB");
        b.setCountryOfOrigin("USA");
        b = breweryRepo.save(b);
        System.out.println("********" + b.getBreweryName());
    //    b.setBreweryId(0);

        for ( int i =0; i<5; i++ ) {
            Drinker drinker = new Drinker();
            drinker.setAvatar("ava");
            drinker.setName("user" + i);

            ArrayList<Beer> beers = new ArrayList<Beer>();

            for (int k =0; k<20; k++ ) {
                Beer beer = new Beer();
                beer.setBeerName("beer" + i+ "-" + k);
                beer.setBrewery(b);
                beers.add(beer);

            }
            drinker.setBeer(beers);

            try {
                drinkerRepo.save(drinker);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Beer> beerList = beerRepo.findByBeerName("beer1-0");


        Beer b1 = beerRepo.findByBeerName("beer1-0").get(0);
        b1.getDrinkerBeer().get(0).setLiked("like");
        beerRepo.save(b1);

       // ArrayList<Beer> untasted = new ArrayList<Beer>();
       // untasted.add(beer);
        Drinker d = drinkerRepo.findByName("user2");
//        d.getBeer().add(beerList.get(0));
 //       drinkerRepo.save(d);

    }
}
