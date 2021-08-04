package com.covid.vaccination.controller;

import com.covid.vaccination.models.Receiver;
import com.covid.vaccination.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Receiver Controller*/

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    //get all receivers
    @RequestMapping(value="/receiver",method= RequestMethod.GET)
    public List<Receiver> getAllReceivers(){
        return receiverService.getAllReceivers();
    }

    //add the receiver
    @RequestMapping(value="/receiver",method=RequestMethod.POST)
    public void addReceiver(@RequestBody Receiver receiver){
        receiverService.addReceiver(receiver);
    }

    //update receiver given id
    @RequestMapping(value="/receiver/{id}",method=RequestMethod.PUT)
    public void updateReceiver(@RequestBody Receiver receiver,@PathVariable String id){
        receiverService.updateReceiver(receiver,id);
    }

    //delete receiver given string id
    @RequestMapping(value="/receiver/{id}",method=RequestMethod.DELETE)
    public void deleteReceiver(@PathVariable String id){
        receiverService.deleteReceiver(id);

    }

    //Complex query 3
    //Get the names of users who have received both the doses of vaccines in the given month.
    @RequestMapping(value="/complex_query3/{month}" , method=RequestMethod.GET)
    public List<String> getUsersReceivedVaccine(@PathVariable String month){
        return receiverService.getUsresreceivedVaccine(month);

    }

    //Complex query 4
    //Get the county where the people have had the maximum side effects after taking the vaccine.
    @RequestMapping(value="/complex_query4",method=RequestMethod.GET)
    public List<String> getCountyWithSideEffects(){
        return receiverService.getCountyWIthSideEffects();
    }

    //Complex query 5
    //Get the names of users who have had body pain for duration greater than the average duration of all other people who have had body pain after taking a particular vaccine.
    @RequestMapping(value="/complex_query5/{name}",method=RequestMethod.GET)
    public List<String> getNoUsers(@PathVariable String name){

        return receiverService.getNoUsers(name);
    }

}
