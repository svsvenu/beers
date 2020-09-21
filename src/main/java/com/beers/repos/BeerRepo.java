package com.beers.repos;

import com.beers.dao.BeerDao;
import com.beers.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
    public interface BeerRepo extends JpaRepository<Beer, Integer> {


        public List<Beer> findByStyle(String firstName);

        public List<Beer> findByBeerName (String beerName);

/*
This query pulls all the beers along with a flag that is set to 1 if the beer has been sampled by the
user and a 0 if it has not been yet.
 */


//    @Query("SELECT distinct new com.beers.dao.BeerDao(b.beerName, b.brewery, " +
//            " CASE WHEN ( d.name = :drinker) THEN '1' ELSE '0' END " +
//            ") FROM Beer  b LEFT OUTER JOIN  b.drinker d  " )
//    public List<BeerDao> beersWithDrinker(String drinker);

    @Query(value = "select b.beer_name as beerName ,b.style as style, b.alcohol_percentage as alcoholPercentage,  bw.brewery_name as brewery, " +
            "case when t.name is null then 0 else 1 end as drinkerName from " +
            "beer b left join ( select db.beer_beer_id, d.name  from drinker_beer db join drinker d on db.drinker_drinker_id = d.drinker_id  where d.name = :drinker ) t on b.beer_id = t.beer_beer_id " +
            "left join brewery bw on b.brewery_brewery_id = bw.brewery_id", nativeQuery = true)
    public List<BeerDao> findByNativeQuery(String drinker);





}
