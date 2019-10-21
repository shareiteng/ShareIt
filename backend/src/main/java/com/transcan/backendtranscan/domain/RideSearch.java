package com.transcan.backendtranscan.domain;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name="ride_search")
public class RideSearch{
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
    public RideSearch(){}
    public RideSearch(String location,String desination, String date, String hours){
        this.location=location;
        this.destination = desination;
        this.date = date;
    }
}
