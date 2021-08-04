package com.covid.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid.vaccination.models.User;
import com.covid.vaccination.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userservice;
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "index";
	}

		@GetMapping("/getLogin/{email}/{password}")
		public ResponseEntity<User> getLogin(@PathVariable String email, @PathVariable String password) {
			try {
				User result = userservice.getLoginDetails(email, password);
				if (result == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(result, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

    //get all users
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userservice.getAllUsers();
    }

    //get user given id
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public User getUserById(@PathVariable String id){

        return userservice.getUserById(id);

    }


    //add user
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userservice.addUser(user);

    }

    //update user given id
    @RequestMapping(value = "/user/{id}",method=RequestMethod.PUT)
    public void updateUser(@RequestBody User user,@PathVariable String id){
        userservice.updateUser(user,id);

    }

    //delete user given id
    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
	    System.out.println(id);
        userservice.deleteUser(id);
    }



}
