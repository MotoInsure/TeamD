package com.ibm.motoInsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.entity.VehicleDetails;
import com.ibm.motoInsure.repository.PolicyRepository;
import com.ibm.motoInsure.repository.VehicleDetailsRepository;
/**
 * <p>This class is implementation of policy service class operations</p>
 * @author Hemaja Patoju
 * @since 18-04-2021
 */
@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepository policyRepo;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	// divided every part to methods for easy understanding
	/**
	 * 
	 * @param vehicle
	 * @return age of vehicle for depreciation calculation
	 */
	
	public int vehicleAge(VehicleDetails vehicle) {
		return LocalDate.now().getYear() - vehicle.getPurchasingYear().getYear();
	}
	/**
	 * 
	 * @param vehicle
	 * @return depreciation in vehicle price
	 */
	
	public double depreciationCalculation(VehicleDetails vehicle) {
		double ActualPrice = vehicle.getPrice();
		double depreciationValue = ActualPrice*0.1;
		return depreciationValue;
	}

	
	@Override
	public double idvCalculation(String registrationNo) {
		VehicleDetails vehicle = vehicleDetailsRepository.findByRegistrationNo(registrationNo);
		double depreciationValue = depreciationCalculation(vehicle);
		double idv = (vehicle.getPrice() - (depreciationValue*vehicleAge(vehicle)))*0.05;
		
		return Math.abs(idv);
	}

	@Override
	public double policyAmount(String registrationNo, String policyType) {
	
		double policyAmount = 0;
		if(policyType.equals("Thirdparty")) {
			policyAmount = idvCalculation(registrationNo);
		}
		else if(policyType.equals("Comprehensive")) {
			policyAmount = idvCalculation(registrationNo)*1.5;
		}
		return policyAmount;
	}

	@Override
	public double maxPolicyClaim(String registrationNo) {
		VehicleDetails vehicle = vehicleDetailsRepository.findByRegistrationNo(registrationNo);
		double depreciationValue = depreciationCalculation(vehicle);
		double presentVehiclePrice = (vehicle.getPrice() - (depreciationValue*vehicleAge(vehicle)));
		
		return Math.abs(presentVehiclePrice);
	}
	
	
	
	
	

	
}
