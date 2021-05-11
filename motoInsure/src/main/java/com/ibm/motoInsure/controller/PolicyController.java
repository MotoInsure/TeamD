package com.ibm.motoInsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.service.PolicyService;
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
	/**
	 * 
	 * @param registrationNo
	 * @return IDV_amount
	 */
	@GetMapping(value = "/calcIDV/{registrationNo}")
	public String calcIDV(@PathVariable(name = "registrationNo") String registrationNo) {
		double idv = policyService.idvCalculation(registrationNo);
		return "IDV of the vehicle :" + idv;
		
	}
	/**
	 * 
	 * @param registrationNo
	 * @param policyType
	 * @return Policy details
	 */
	@GetMapping(value = "/calcPolicyAmount/{registrationNo}/{policyType}")
	public String calcPolicyAmount(@PathVariable(name = "registrationNo") String registrationNo,@PathVariable(name = "policyType") String policyType) {
		double policyAmount = policyService.policyAmount(registrationNo, policyType);
		return "Policy amount of vehicle selcted "+ policyType+":"+policyAmount	;
	}
	/**
	 * 
	 * @param registrationNo
	 * @return max_claim amount
	 */
	
	@GetMapping(value = "/calcMaxPolicyClaim/{registrationNo}")
	public String maxPolicyClaim(@PathVariable(name = "registrationNo") String registrationNo) {
		double maxPolicyClaim = policyService.maxPolicyClaim(registrationNo);
		return "Inspite o selecting any type of policy, this user can claim max policy amount:" + maxPolicyClaim;
		
	}
	

}
