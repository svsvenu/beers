package com.beers.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Drinker {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int drinkerId;
    private String name;
    private String avatar;
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Beer> beer;
    @OneToMany(mappedBy = "drinker",cascade = {CascadeType.ALL})

    private List<DrinkerBeer> drinkerBeer = new ArrayList<DrinkerBeer>();
}
