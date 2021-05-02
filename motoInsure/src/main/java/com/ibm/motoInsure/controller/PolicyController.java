package com.ibm.motoInsure.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/calcIDV/{registrationNo}")
	public ResponseEntity<String> calcIDV(@PathVariable(name = "registrationNo") String registrationNo) {
		double idv = policyService.idvCalculation(registrationNo);
		return new ResponseEntity<String>("IDV of the vehicle :" + idv, HttpStatus.OK) ;
		
	}

	@GetMapping(value = "/calcPolicyAmount/{registrationNo}/{policyType}")
	public ResponseEntity<String> calcPolicyAmount(@PathVariable(name = "registrationNo") String registrationNo,@PathVariable(name = "policyType") String policyType) {
		double policyAmount = policyService.policyAmount(registrationNo, policyType);
		return new ResponseEntity<String>("Policy amount of vehicle selcted "+ policyType+":"+policyAmount	, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/calcMaxPolicyClaim/{registrationNo}")
	public ResponseEntity<String> maxPolicyClaim(@PathVariable(name = "registrationNo") String registrationNo) {
		double maxPolicyClaim = policyService.maxPolicyClaim(registrationNo);
		return new ResponseEntity<String>("Inspite o selecting any type of policy, this user can claim max policy amount:" + maxPolicyClaim, HttpStatus.OK) ;
		
	}
	

}
