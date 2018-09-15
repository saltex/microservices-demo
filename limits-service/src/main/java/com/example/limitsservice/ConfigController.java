package com.example.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Configuration configuration;

    @GetMapping
    public LimitsConfiguration getLimits() {
        return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
