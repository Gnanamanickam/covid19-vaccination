package com.covid.vaccination.controller;

//import com.covid.vaccination.service.CenterService;
import com.covid.vaccination.models.VaccinationCentre;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.covid.vaccination.service.VaccinationCenterService;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VaccineCenterController {

//    @Autowired
//    private CenterService centerService;

    @Autowired
    VaccinationCenterService vaccinationCentreService;

    //Simple query 1
    // Select the state which has received highest vaccination till date
    @RequestMapping(value = "/simple_query1",method=RequestMethod.GET)
    public String getAllCentersQuery(){
        return vaccinationCentreService.getALlVaccinationCentersQuery();
    }

    //Simple query 2
    // List the counties which have vaccination rate less than 50%
    @RequestMapping(value = "/simple_query2",method=RequestMethod.GET)
    public List<VaccinationCentre> getLessVaccinatedQuery(){
        return vaccinationCentreService.getLessVaccinatedQuery();
    }

    //Simple query 3
    // List the county which has the highest vaccination centers
    @RequestMapping(value = "/simple_query3/{state}",method=RequestMethod.GET)
    public List<VaccinationCentre> getCountyHighestState(@PathVariable String state){
        return vaccinationCentreService.getCountyHighestState(state);
    }






}
