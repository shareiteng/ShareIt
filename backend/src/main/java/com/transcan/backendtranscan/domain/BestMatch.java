package com.transcan.backendtranscan.domain;

import com.transcan.backendtranscan.domain.UserInfo;
import lombok.Data;
import javax.persistence.*;


import javax.persistence.*;






@Data
@Entity
@Table(name="bestmatch")
public class BestMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long searchId;
    private String location;
    private String destination;
    private String date;
    private String hours;
    private String locLatLng;
    private String desLatLng;
    @ManyToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


    public BestMatch(){}
    public BestMatch(String location, String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
    }
    public BestMatch(RideSearch rideSearch){
        this.location=rideSearch.getLocation();
        this.destination = rideSearch.getDestination();
        this.date = rideSearch.getDate();
        this.userInfo = rideSearch.getUserInfo();
    }
    public void setRideSearch(String location,String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
        this.hours=hours;
    }
}
