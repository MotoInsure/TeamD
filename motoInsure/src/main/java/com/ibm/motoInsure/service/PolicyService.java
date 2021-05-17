package com.ibm.motoInsure.service;

import org.springframework.stereotype.Service;
import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.Vehicle;

/**
 *<p>This service interface is for policy containing logic for calculation operations</p>
 * @author Hemaja Patoju
 * @since 18-04-2021
 *
 */
public interface PolicyService {

	
	double dvCalculation(String registrationNo);
	double policyAmount(String registrationNo, String policyType);
	double insuredDeclaredValue(String registrationNo);
	int savePolicy(Policy policy);
}
