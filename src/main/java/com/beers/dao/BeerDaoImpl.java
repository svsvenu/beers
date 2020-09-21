package com.beers.dao;

import lombok.Data;

@Data
public class BeerDaoImpl implements  BeerDao {
    String beerName;
    String style;


    String brewery;
    String alcoholPercentage;


    String drinkerName;
    String liked;


}
