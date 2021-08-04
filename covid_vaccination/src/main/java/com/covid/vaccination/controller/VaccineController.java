package com.covid.vaccination.controller;

import com.covid.vaccination.models.Vaccine;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VaccineController {

	@Autowired
	VaccineService vaccineService;

	//get all vaccines
	@RequestMapping(value = "/vaccine", method = RequestMethod.GET)
	public List<Vaccine> getAllVaccines(){
		return vaccineService.getAllVaccines();
	}

	//add vaccine
	@RequestMapping(value="/vaccine",method = RequestMethod.POST)
	public void addVaccine(@RequestBody Vaccine vaccine){
		vaccineService.addVaccine(vaccine);
	}

	//update vaccine given id
	@RequestMapping(value="/vaccine/{id}",method=RequestMethod.PUT)
	public void updateVaccine(@RequestBody Vaccine vaccine,@PathVariable String id){
		vaccineService.updateVaccine(vaccine,id);
	}

	//delete vaccine given id
	@RequestMapping(value="/vaccine/{id}",method=RequestMethod.DELETE)
	public void deleteVaccine(@PathVariable String id){
		vaccineService.deleteVaccine(id);
	}


}
