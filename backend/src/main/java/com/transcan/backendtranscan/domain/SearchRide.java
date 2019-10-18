package com.transcan.backendtranscan.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class SearchRide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long searchid;
    private String origin;
    private String desination;
    private Date date;
    private long userid;

}
