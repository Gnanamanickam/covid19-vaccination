package com.covid.vaccination.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stock")
public class Stock {
@Id
@Column(name="stock_id")
String stock_id;
@Column(name="vaccine_id")
int vaccine_id;
@Column(name="center_id")
int center_id;
@Column(name="stock")
long stock;

    public Stock(String stock_id, int vaccine_id, int center_id, long stock) {
        this.stock_id = stock_id;
        this.vaccine_id = vaccine_id;
        this.center_id = center_id;
        this.stock = stock;
    }

    public Stock() {

    }


    public String getStock_id() {
        return stock_id;
    }

    public int getVaccine_id() {
        return vaccine_id;
    }

    public int getCenter_id() {
        return center_id;
    }

    public long getStock() {
        return stock;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public void setVaccine_id(int vaccine_id) {
        this.vaccine_id = vaccine_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
