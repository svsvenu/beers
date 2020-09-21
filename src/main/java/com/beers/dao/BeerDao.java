package com.beers.dao;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

//@Data
@JsonPropertyOrder({ "beerName",  "brewery", "alcoholPercentage", "style","drinkerName", "liked" })
public interface BeerDao {



    String getBeerName();
    String getStyle();


    String getBrewery();
    String getAlcoholPercentage();


    String getDrinkerName();

    String getLiked();

}
