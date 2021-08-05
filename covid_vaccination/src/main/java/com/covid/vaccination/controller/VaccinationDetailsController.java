package com.covid.vaccination.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid.vaccination.models.User;
import com.covid.vaccination.utils.FetchData;

public class VaccinationDetailsController {
	
	@Autowired
	FetchData fetchdata;
	
	@GetMapping("/getVaccinationDetails")
	public ResponseEntity<JSONArray> getVaccinationDetails() {
		try {
			JSONArray result = fetchdata.getDetails("SELECT * FROM covid_vaccination.vaccination_details where location='United States';");
				if (result == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
