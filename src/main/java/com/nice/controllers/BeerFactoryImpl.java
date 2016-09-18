package com.nice.controllers;

import com.nice.dao.BeerDao;
import com.nice.data.Beer;
import lombok.Setter;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 18/09/2016.
 */
@Service
@Transactional
@Setter
public class BeerFactoryImpl implements BeerFactory {
    @Autowired
    private BeerDao beerDao;

    private DataFactory dataFactory = new DataFactory();

    @Override
    public Beer getRandomBeer() {
        List<Beer> beers = beerDao.findAll();
        return dataFactory.getItem(beers);
    }

    @Override
    public void saveBeer(Beer beer) {

        if (beer.getPrice() < 0) {
            throw new IllegalStateException("price can't be negative");
        }
        beerDao.save(beer);
    }

    @Override
    public List<Beer> getBeersAbovePrice(int price) {
        return beerDao.findPleeeeeaseByPriceGreaterThan(price);
    }

    @Override
    public List<Beer> getBeersBetweenPrice(int min, int max) {
        return beerDao.findByPriceBetween(min, max);
    }

    @Override
    public long maxPrice() {
        return beerDao.maxPrice();
    }
}
