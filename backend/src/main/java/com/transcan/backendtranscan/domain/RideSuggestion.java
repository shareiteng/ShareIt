
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
    private long userId;
    private String distination;
    private String location;

    private String days;
    private  String remarks;
    private String date;
    private  String houers;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


}
