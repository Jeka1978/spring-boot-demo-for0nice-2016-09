package com.nice.dao;

import com.nice.data.Beer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Evegeny on 18/09/2016.
 */
@Repository
public class BeerDao2Impl implements BeerDao2 {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveBeer(Beer beer) {
        entityManager.persist(beer);
    }
}
