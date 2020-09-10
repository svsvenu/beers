package com.beers.repos;

import com.beers.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
    public interface BeerRepo extends JpaRepository<Beer, Integer> {


        public List<Beer> findByStyle(String firstName);

}
