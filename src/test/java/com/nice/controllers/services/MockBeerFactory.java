package com.nice.controllers.services;

import com.nice.controllers.BeerFactory;
import com.nice.data.Beer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 18/09/2016.
 */
//@Service
public class MockBeerFactory implements BeerFactory {
    @Override
    public Beer getRandomBeer() {
        return new Beer("Goldstar",5);
    }

    @Override
    public void saveBeer(Beer beer) {
        //nothing to do, it's a mock
    }

    @Override
    public List<Beer> getBeersAbovePrice(int price) {
        return null;
    }

    @Override
    public List<Beer> getBeersBetweenPrice(int min, int max) {
        return null;
    }

    @Override
    public long maxPrice() {
        return 0;
    }
}
