package com.covid.vaccination.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="ssn")
    long ssn;
    @Column(name="name")
    String name;
    @Column(name="phone_number")
    long phone_number;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;
    @Column(name="county")
    String county;
    @Column(name="state")
    String state;


    public User(long ssn, String name, long phone_number, String email, String password, String county, String state) {
        this.ssn = ssn;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.county = county;
        this.state = state;
    }

    public User() {

    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
