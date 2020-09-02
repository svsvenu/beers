package com.beers;


import com.beers.controllers.BeerRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
public class BeerSpringApplicationTest
{

    @Autowired
    private BeerRestController controller;
    @Test
    public void contextLoads() {

        System.out.println("Controller is " + controller);

        assertThat(controller).isNotNull();
    }




}