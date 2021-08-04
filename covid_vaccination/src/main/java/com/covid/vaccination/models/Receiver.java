package com.covid.vaccination.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* receiver entity class */

@Entity
@Table(name="receiver")
public class Receiver {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "user_id")
    int user_id;
    @Column(name = "vaccine_id")
    int vaccine_id;
    @Column(name = "center_id")
    int center_id;
    @Column(name="receive_date")
    String receive_date;

    public Receiver(String id, int user_id, int vaccine_id, int center_id) {
        this.id = id;
        this.user_id = user_id;
        this.vaccine_id = vaccine_id;
        this.center_id = center_id;
    }

    public Receiver() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVaccine_id() {
        return vaccine_id;
    }

    public void setVaccine_id(int vaccine_id) {
        this.vaccine_id = vaccine_id;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }
}
