package com.vehicletrack.trackerapi.controller;

import com.vehicletrack.trackerapi.model.Driver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {
    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Hello");
        return "Hello";
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {

        System.out.println("Name from simulator : "+driver.getFirstName());
        driver.setFirstName("Dejach");
        return driver;
    }

}
