package com.nice.dao;

import com.nice.data.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Evegeny on 18/09/2016.
 */
public interface BeerDao extends JpaRepository<Beer,Integer> {
    List<Beer> findPleeeeeaseByPriceGreaterThan(int price);


    List<Beer> findByPriceBetween(int min, int max);

    @Query("select max (b.price) from Beer as b")
    long maxPrice();
}
