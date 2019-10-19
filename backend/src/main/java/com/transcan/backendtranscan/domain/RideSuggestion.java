
package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="ride_suggestion")
public class RideSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long driverId;
    private String destinatin;
    private String location;
    private String value;
    private  String remarks;
    private String date;
    private  String hours;

    @ManyToMany(mappedBy = "vehicleUse")
    Set<VehicleInfo> likes;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


}
