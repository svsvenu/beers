package com.beers.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "DRINKER_BEER")

public class DrinkerBeer implements Serializable {

   // @Column(name="drinker_drinker_id")
   // @Id
   // private int drinkerDrinkerId;
   // @Column(name="beers_sampled_beer_id")
   // @Id

   // private int beersSampledBeerId;
   @Id @GeneratedValue(strategy=GenerationType.IDENTITY)

   private int Id;
     @ManyToOne
     @JoinColumn(name = "BEER_BEER_ID")
     private Beer beer;

     @ManyToOne
     @JoinColumn(name = "DRINKER_DRINKER_ID")
     private Drinker drinker;
     private String liked;





 }
