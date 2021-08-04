package com.covid.vaccination.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccination_details")
public class CovidVaccinationDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="location")
	String location;

	@Column(name="region")
	String region;
	
	@Column(name="date")
	Date date;
	
	@Column(name="location_iso")
	String location_iso;
	
	@Column(name="region_iso")
	String region_iso;
	
	@Column(name="total_vaccinations")
	int total_vaccinations;
	
	@Column(name="people_vaccinated")
	int people_vaccinated;
	
	@Column(name="people_fully_vaccinated")
	int people_fully_vaccinated;
	
	@Column(name="total_vaccinations_per_100")
	double total_vaccinations_per_100;
	
	@Column(name="people_vaccinated_per_100")
	double people_vaccinated_per_100;
	
	@Column(name="people_fully_vaccinated_per_100")
	double people_fully_vaccinated_per_100;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation_iso() {
		return location_iso;
	}

	public void setLocation_iso(String location_iso) {
		this.location_iso = location_iso;
	}

	public String getRegion_iso() {
		return region_iso;
	}

	public void setRegion_iso(String region_iso) {
		this.region_iso = region_iso;
	}

	public int getTotal_vaccinations() {
		return total_vaccinations;
	}

	public void setTotal_vaccinations(int total_vaccinations) {
		this.total_vaccinations = total_vaccinations;
	}

	public int getPeople_vaccinated() {
		return people_vaccinated;
	}

	public void setPeople_vaccinated(int people_vaccinated) {
		this.people_vaccinated = people_vaccinated;
	}

	public int getPeople_fully_vaccinated() {
		return people_fully_vaccinated;
	}

	public void setPeople_fully_vaccinated(int people_fully_vaccinated) {
		this.people_fully_vaccinated = people_fully_vaccinated;
	}

	public double getTotal_vaccinations_per_100() {
		return total_vaccinations_per_100;
	}

	public void setTotal_vaccinations_per_100(double total_vaccinations_per_100) {
		this.total_vaccinations_per_100 = total_vaccinations_per_100;
	}

	public double getPeople_vaccinated_per_100() {
		return people_vaccinated_per_100;
	}

	public void setPeople_vaccinated_per_100(double people_vaccinated_per_100) {
		this.people_vaccinated_per_100 = people_vaccinated_per_100;
	}

	public double getPeople_fully_vaccinated_per_100() {
		return people_fully_vaccinated_per_100;
	}

	public void setPeople_fully_vaccinated_per_100(double people_fully_vaccinated_per_100) {
		this.people_fully_vaccinated_per_100 = people_fully_vaccinated_per_100;
	}

	@Override
	public String toString() {
		return "CovidVaccinationDetails [id=" + id + ", location=" + location + ", region=" + region + ", date=" + date
				+ ", location_iso=" + location_iso + ", region_iso=" + region_iso + ", total_vaccinations="
				+ total_vaccinations + ", people_vaccinated=" + people_vaccinated + ", people_fully_vaccinated="
				+ people_fully_vaccinated + ", total_vaccinations_per_100=" + total_vaccinations_per_100
				+ ", people_vaccinated_per_100=" + people_vaccinated_per_100 + ", people_fully_vaccinated_per_100="
				+ people_fully_vaccinated_per_100 + "]";
	}

	
	
}
