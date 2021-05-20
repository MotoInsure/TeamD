package com.ibm.motoInsure.controller;

import java.util.Optional;

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
import com.ibm.motoInsure.entity.User;
import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.repository.UserRepository;
import com.ibm.motoInsure.service.PolicyService;
import com.ibm.motoInsure.service.UserService;
/**
 * <p>Policy controller controls data flow for calculation methods like IDV, Policy amount and max_claim amount in Policy</p>
 * @author Hemaja Patoju
 * @since 18-04-2021
 */

@RestController
@RequestMapping(value = "/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @param registrationNo
	 * @return IDV_amount
	 */
	@GetMapping(value = "/calcIDV/{registrationNo}")
	public ResponseEntity<String> calcIDV(@PathVariable(name = "registrationNo") String registrationNo) {
		double idv = policyService.dvCalculation(registrationNo);
		return new ResponseEntity<String>("IDV of the vehicle :" + idv, HttpStatus.OK) ;
		
	}
	/**
	 * 
	 * @param registrationNo
	 * @param policyType
	 * @return Policy details
	 */
	@GetMapping(value = "/policyAmount/{registrationNo}/{policyType}")
	public ResponseEntity<String> policyAmount(@PathVariable(name = "registrationNo") String registrationNo,@PathVariable(name = "policyType") String policyType) {
		double policyAmount = policyService.policyAmount(registrationNo, policyType);
		return new ResponseEntity<String>("Policy amount of vehicle selcted "+ policyType+":"+policyAmount	, HttpStatus.OK) ;
	}
	/**
	 * 
	 * @param registrationNo
	 * @return max_claim amount
	 */
	
	@GetMapping(value = "/IDV/{registrationNo}")
	public ResponseEntity<String> IDV(@PathVariable(name = "registrationNo") String registrationNo) {
		double maxPolicyClaim = policyService.insuredDeclaredValue(registrationNo);
		return new ResponseEntity<String>("Inspite of selecting any type of policy, this user can claim max policy amount:" + maxPolicyClaim, HttpStatus.OK) ;
		
	}
	@PostMapping(value ="/addPolicy/{userId}")
	public ResponseEntity<String> insertPolicy(@RequestBody Policy policy,@PathVariable int userId){
		
		int policyId = policyService.savePolicy(policy);
		User user = userService.getUserById(userId);
		policy.setUser(user);
		policyService.savePolicy(policy);
		return new ResponseEntity<String>("Policy added successfully:"+policyId, HttpStatus.CREATED);
	}
	

}
