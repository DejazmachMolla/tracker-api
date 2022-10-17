package com.vehicletrack.trackerapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Driver {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Boolean isOnline;
    private Boolean serving;
    private Boolean acceptedCall;
    private LocationUpdate latestLocationUpdate;


}
