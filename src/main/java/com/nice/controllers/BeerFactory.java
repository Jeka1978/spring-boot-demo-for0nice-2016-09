package com.nice.controllers;

import com.nice.data.Beer;

import java.util.List;

/**
 * Created by Evegeny on 18/09/2016.
 */
public interface BeerFactory {
    Beer getRandomBeer();

    void saveBeer(Beer beer);

    List<Beer> getBeersAbovePrice(int price);
    List<Beer> getBeersBetweenPrice(int min, int max);

    long maxPrice();

}
