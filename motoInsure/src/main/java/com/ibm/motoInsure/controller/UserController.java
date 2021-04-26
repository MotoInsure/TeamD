package com.ibm.motoInsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired 
	private UserService us;
	
	@PostMapping(value="/addPolicyToUser/{userId}/{policyId}")
	private String addPolicyToUser(@PathVariable int userId,@PathVariable int policyId) {
		us.addPolicyToUser(userId, policyId);
		return "PolicyId has been added to the user.";
	}
	@PostMapping(value="/addVehicle/{userId}/{vehicleId}", consumes="application/json")
	private String addUserVehicle(@PathVariable int userId,@PathVariable String vehicleId) {
		us.addUserVehicle(userId,vehicleId);
		return "Task Done.";
	}
}
