package com.ibm.motoInsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.repository.PolicyRepo;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public double idvCalculation(Vehicle vehicle) {
		double sellingPrice = vehicle.getPrice();
		int years = LocalDate.now().getYear() - vehicle.getPurchasingYear().getYear();
		double depreciationValue = sellingPrice*0.1;
		
		double idv = (sellingPrice - (depreciationValue*years))*0.05;
		
		return idv;
	}
	
/*	(no need)
 * @Override
	public int addPolicy(Policy policy) {
		//policyRepo.save(policy);
		  //return ;   
		  
		  //This will only return the whole policy added to the table
		 
		return policyRepo.save(policy).getId(); // returns the policy id which is added to table.
	}*/

	
}
