package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="ride_search")
public class RideSearch{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long searchId;
    private String location;
    private String desination;
    private String date;
    private  String houers;
    private long userId;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

}
