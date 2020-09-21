package com.beers.repos;

import com.beers.entity.Beer;
import com.beers.entity.Drinker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkerRepo extends JpaRepository<Drinker, Integer>{


    public Drinker findByName(String name);

}
