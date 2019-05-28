package com.transcan.backendtranscan.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    @NotBlank (message = "E-mail cannot be blank")
    private String email;
    @NotBlank (message = "Password cannot be blank")
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private long score;


}
