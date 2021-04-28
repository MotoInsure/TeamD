package com.ibm.motoInsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;

@Service
public class PolicyServiceImpl implements PolicyService {

	
	// divided every part to methods for easy understanding
	
	public int vehicleAge(Vehicle vehicle) {
		return LocalDate.now().getYear() - vehicle.getPurchasingYear().getYear();
	}
	
	public double depreciationCalculation(Vehicle vehicle) {
		double ActualPrice = vehicle.getPrice();
		double depreciationValue = ActualPrice*0.1;
		return depreciationValue;
	}

	@Override
	public double idvCalculation(Vehicle vehicle) {
		
		double depreciationValue = depreciationCalculation(vehicle);
		double idv = (vehicle.getPrice() - (depreciationValue*vehicleAge(vehicle)))*0.05;
		
		return idv;
	}

	@Override
	public double policyAmount(Vehicle vehicle, String policyType) {
	
		double policyAmount = 0.00;
		if(policyType =="Third-party") {
			policyAmount = idvCalculation(vehicle);
		}
		else if(policyType =="Comprehensive") {
			policyAmount = idvCalculation(vehicle)*1.5;
		}
		return 0;
	}

	@Override
	public double maxPolicyClaim(Vehicle vehicle) {
		double ActualPrice = vehicle.getPrice();
		int years = LocalDate.now().getYear() - vehicle.getPurchasingYear().getYear();
		double PresentVehiclePrice = ActualPrice*0.1;
		
		return PresentVehiclePrice;
	}
	
	
	
	
	

/*	(no need)
 * @Override
	public int addPolicy(Policy policy) {
		//policyRepository.save(policy);

		  //return ;   
		  
		  //This will only return the whole policy added to the table
		 
		return policyRepo.save(policy).getId(); // returns the policy id which is added to table.
	}*/

	
}
