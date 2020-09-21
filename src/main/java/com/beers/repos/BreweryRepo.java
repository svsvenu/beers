package com.beers.repos;


import com.beers.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepo extends JpaRepository<Brewery, Integer> {
}
