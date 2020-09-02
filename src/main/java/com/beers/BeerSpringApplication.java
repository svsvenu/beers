package com.beers;



import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan
public class BeerSpringApplication {

    public BeerSpringApplication(){
        log.info("constructed BeerSpringApplication");
    }

    public static void main(String[] args) {
        SpringApplication.run(BeerSpringApplication.class, args);
    }

}