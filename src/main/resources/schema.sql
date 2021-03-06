CREATE TABLE country (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE USERS (
    USERNAME VARCHAR(128) NOT NULL ,
    PASSWORD VARCHAR(128) NOT NULL,
    ENABLED VARCHAR(128) NOT NULL,

    PRIMARY KEY (USERNAME)
);

CREATE TABLE AUTHORITIES (
    USERNAME VARCHAR(128) NOT NULL ,
    AUTHORITY VARCHAR(128) NOT NULL,
    PRIMARY KEY (USERNAME)
);


CREATE TABLE DRINKER (
    drinker_id   BIGINT     AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    avatar VARCHAR(128),
        test VARCHAR(128),


    PRIMARY KEY (drinker_id)
);
/*

CREATE TABLE DRINKER_BEERS_SAMPLED (

    drinker_drinker_id BIGINT,
      beers_sampled_beer_id   BIGINT

);
*/



CREATE TABLE BEER (
    beer_id   BIGINT     AUTO_INCREMENT,
     beer_name VARCHAR(128) ,
     brewery VARCHAR(128) ,
     alcohol_percentage VARCHAR(128) ,
    style VARCHAR(128),


    PRIMARY KEY (beer_id)
);

