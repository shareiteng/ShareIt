package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "vehicle_info")
public class VehicleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleid;
    private String vehicletype;
    private int seat;

    @ManyToMany
    @JoinTable(
            name = "vehicle",
            joinColumns = @JoinColumn(name = "vehicleid"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
            Set<RideSuggestion> vehicleUse;

}

