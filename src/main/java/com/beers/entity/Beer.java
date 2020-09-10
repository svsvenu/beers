package com.beers.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Beer {
    @Id
    @GeneratedValue
    private int id;
    private String beerName;
    private String brewery;
    private float alcoholPercentage = 5.1f;
    private String style = "stout";
}
