package com.vehicletrack.trackerapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter @Setter
public class LocationUpdate {
    private Integer id;
    private ZonedDateTime updateTime;
    private Double latitude;
    private Double longitude;
    //private Driver driver;
}
