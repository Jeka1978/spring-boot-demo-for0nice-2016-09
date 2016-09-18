package com.nice.controllers;

import com.nice.data.Beer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by Evegeny on 18/09/2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerFactory beerFactory;


    @Before
    public void setUp() throws Exception {
        Mockito.when(beerFactory.getRandomBeer()).thenReturn(new Beer("makabi",3));

    }

    @Test
    public void testBeer() throws Exception {
        mockMvc.perform(get("/beer")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name",equalTo("makabi"))).
                andExpect(jsonPath("$.price",equalTo(3)));
    }

}