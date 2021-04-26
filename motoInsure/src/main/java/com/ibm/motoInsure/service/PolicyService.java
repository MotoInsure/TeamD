package com.ibm.motoInsure.service;

import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;

@Service
public interface PolicyService {

//(no need)	int addPolicy(Policy policy);
	
	double idvCalculation(Vehicle vehicle);
	double policyAmount(Vehicle vehicle, String policyType);
	double maxPolicyClaim(Vehicle vehicle);
}
