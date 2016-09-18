package com.nice.controllers;

import com.nice.data.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Evegeny on 18/09/2016.
 */
@RestController
public class BeerController {

    @Autowired
    private BeerFactory beerFactory;

    @GetMapping("/ping/{name}/{x}")
    public String ping(@PathVariable String name, @PathVariable int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(name).append(" ");
        }
        return "ping is ok! " + sb.toString();
    }


    @GetMapping("/beer")
    public Beer getBeer() {
        return beerFactory.getRandomBeer();
    }

    @PostMapping("/beer")
    public String addBeer(@RequestBody Beer beer) {
        beerFactory.saveBeer(beer);
        return "beer was saved, current id is: " + beer.getId();
    }

    @GetMapping("/beer/{price}")
    public List<Beer> getBeersAbovePrice(@PathVariable int price) {
        return beerFactory.getBeersAbovePrice(price);
    }

    @GetMapping("/beer/{min}/{max}")
    public List<Beer> getBeersBetweenPrice(@PathVariable int min,@PathVariable int max) {
        return beerFactory.getBeersBetweenPrice(min,max);
    }

    @GetMapping("/beer/max")
    public long maxPrice() {
        return beerFactory.maxPrice();
    }

}
