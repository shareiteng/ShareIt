package com.transcan.backendtranscan.domain;

import com.transcan.backendtranscan.domain.UserInfo;
import lombok.Data;
import javax.persistence.*;


import javax.persistence.*;
import java.util.ArrayList;


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
    private ArrayList<Long> passengersId;
    private String locLatLngMatch;
    private String desLatLngMatch;
    @ManyToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


    public BestMatch(){}
    public BestMatch(String location, String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
        this.hours=hours;
    }
    public BestMatch(RideSearch rideSearch, ArrayList<Long> passengersId, String locLatLngMatch, String desLatLngMatch){
        this.location=rideSearch.getLocation();
        this.destination = rideSearch.getDestination();
        this.date = rideSearch.getDate();
        this.hours=rideSearch.getHours();
        this.userInfo = rideSearch.getUserInfo();
        this.passengersId=passengersId;
        this.locLatLngMatch=locLatLngMatch;
        this.desLatLngMatch=desLatLngMatch;
    }

    public BestMatch(RideSuggestion rideSuggestion, ArrayList<Long> passengersId, String locLatLngMatch, String desLatLngMatch){
        this.location=rideSuggestion.getLocation();
        this.destination = rideSuggestion.getDestination();
        this.date = rideSuggestion.getDate();
        this.userInfo = rideSuggestion.getUserInfo();
        this.passengersId=passengersId;
        this.locLatLngMatch=locLatLngMatch;
        this.desLatLngMatch=desLatLngMatch;
    }
    public void setRideSearch(String location,String destination, String date, String hours){
        this.location=location;
        this.destination = destination;
        this.date = date;
        this.hours=hours;
    }
}
