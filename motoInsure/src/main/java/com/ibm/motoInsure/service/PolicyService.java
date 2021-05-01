package com.ibm.motoInsure.service;

import org.springframework.stereotype.Service;
import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.Vehicle;


public interface PolicyService {

	
	double idvCalculation(String registrationNo);
	double policyAmount(String registrationNo, String policyType);
	double maxPolicyClaim(String registrationNo);
}
