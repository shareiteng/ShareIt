package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class RideInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rideid;
    private String rorigin;
    private  String rdestination;
    private Date rdate;
    private Time rhour;
    private long vehicleid;
    private String remarks;
}
