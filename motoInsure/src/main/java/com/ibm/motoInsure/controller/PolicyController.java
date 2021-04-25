package com.ibm.motoInsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.service.PolicyService;

@RestController
@RequestMapping(value = "/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@PostMapping(value = "/calcIDV")
	public String calcIDV(@RequestBody Vehicle vehicle) {
		double idv = policyService.idvCalculation(vehicle);
		return "IDV of the vehicle :" + idv;
		
	}

	//(no need)
//	@PostMapping(value = "/addPolicy")
//	public String addPolicy(@RequestBody Policy policy){
//		int policyId = policyService.addPolicy(policy);
//		return "Policy added with id: " + policyId; 
//	}
//	
//	public void updatePolicy() {
//	}
}
