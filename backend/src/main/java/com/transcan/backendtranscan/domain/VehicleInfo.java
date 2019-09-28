package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "vehicle_info")
public class VehicleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleid;
    private String vehicletype;
    private int seat;

}
