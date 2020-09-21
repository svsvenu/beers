package com.beers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Beer {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int beerId;
    private String beerName;
    @ManyToOne()
    @JoinColumn(name="brewery_brewery_id")
    private Brewery brewery;
   // private Set<UserGroup> userGroups = new HashSet<UserGroup>();

    @ManyToMany(mappedBy = "beer", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<DrinkerBeer> drinkerBeer = new ArrayList<DrinkerBeer>();

    private float alcoholPercentage = 5.1f;
    private String style = "stout";
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "DRINKER_BEER",
            joinColumns = @JoinColumn(name = "BEER_BEER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DRINKER_DRINKER_ID")
    )
@JsonIgnore
    private List<Drinker> drinker;


}
