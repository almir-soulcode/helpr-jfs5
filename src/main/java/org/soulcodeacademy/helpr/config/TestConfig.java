package org.soulcodeacademy.helpr.config;


import org.hibernate.cfg.Environment;
import org.soulcodeacademy.helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Profile("teste")
@Configuration
public class TestConfig {



    @Autowired
    private PopulateService populateService;



    @PostConstruct
    public void init() {
        this.populateService.populate();
    }
}
