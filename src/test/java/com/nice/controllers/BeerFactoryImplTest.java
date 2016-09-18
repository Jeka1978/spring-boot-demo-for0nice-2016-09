package com.nice.controllers;

import com.nice.dao.BeerDao;
import com.nice.data.Beer;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 18/09/2016.
 */
public class BeerFactoryImplTest {
    @Test(expected = IllegalStateException.class)
    public void saveBeerWithNegativePrice() throws Exception {
        BeerFactoryImpl beerFactory = new BeerFactoryImpl();
        BeerDao beerDaoMock = mock(BeerDao.class);
        Beer beer = new Beer("", -29);
        when(beerDaoMock.save(beer)).thenThrow(new UnsupportedOperationException("can't add negative price for beer"));
        beerFactory.setBeerDao(beerDaoMock);
        beerFactory.saveBeer(beer);

    }

}