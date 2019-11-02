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
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


    public BestMatch(){}
    public BestMatch(String location, String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
    }
    public void setRideSearch(String location,String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
        this.hours=hours;
    }
}
