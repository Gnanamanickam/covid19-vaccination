package com.covid.vaccination.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccination_center")
public class VaccinationCentre {

    @Id
    @Column(name="id")
    public long id;
    @Column(name="name")
    public String name;
    @Column(name="county")
    public String county;
    @Column(name="state")
    public String state;
    @Column(name="vaccinated")
    public String vaccinated;

    public VaccinationCentre(long id, String name, String county, String state, String vaccinated) {
        this.id = id;
        this.name = name;
        this.county = county;
        this.state = state;
        this.vaccinated = vaccinated;
    }

    public VaccinationCentre() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }
}
