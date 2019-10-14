package com.transcan.backendtranscan.domain;

import com.transcan.backendtranscan.domain.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class UserInfo extends DateAudit {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User name cannot be blank, must have min 6 characters and max 15 characters")
    @Size(max=15,min=6)
    private String username;

    @NotBlank (message = "E-mail cannot be blank")
    @Email
    private String email;

    @NotBlank
    private String password;

    private String firstname;

    private String lastname;

    private String phone;

    private long score;

    @OneToOne
    private RideSuggestion rideSuggestion;

    @ManyToOne
    private RideSearch rideSearch;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserInfo(){

    }
    public UserInfo(String username,String email,String password,String firstname,String lastname){
        this.username=username;
        this.email=email;
        this.password=password;
        this.firstname= firstname;
        this.lastname=lastname;
        this.phone="";
        this.score=0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public RideSuggestion getRideSuggestion() {
        return rideSuggestion;
    }

    public void setRideSuggestion(RideSuggestion rideSuggestion) {
        this.rideSuggestion = rideSuggestion;
    }

    public RideSearch getRideSearch() {
        return rideSearch;
    }

    public void setRideSearch(RideSearch rideSearch) {
        this.rideSearch = rideSearch;
    }
}
