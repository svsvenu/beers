package com.beers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Brewery {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int breweryId;
    private String breweryName;
    private Date established;
    private String countryOfOrigin;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,  mappedBy = "brewery")
    @JsonIgnore
    private List<Beer> beers;
    public void addBeer(Beer beer) {
        beers.add(beer);
        beer.setBrewery(this);
    }

    public void removeBeer(Beer beer) {
        beers.remove(beer);
        beer.setBrewery(null);
    }
}
