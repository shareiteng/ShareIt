package com.transcan.backendtranscan.domain.audit;

import com.transcan.backendtranscan.domain.UserInfo;
import lombok.Data;
import javax.persistence.*;


import javax.persistence.*;


@Data
@Entity
@Table(name="matchtable")
public class MatchTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long searchId;
    private String location;
    private String destination;
    private String date;
    private String hours;
    private String locLatLng;
    private String desLatLng;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;


    public MatchTable(){}
    public MatchTable(String location, String desination, String date, String hours){
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
