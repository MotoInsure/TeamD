package com.ibm.motoInsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.motoInsure.entity.Policy;
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
	
	// this method is used to the calculate the age of the vehicle
	public int vehicleAge(VehicleDetails vehicle) {
		return LocalDate.now().getYear() - vehicle.getPurchasingYear().getYear();
	}
	/**
	 * 
	 * @param vehicle
	 * @return depreciation in vehicle price
	 */
	// this method is 1st part to calculate the vehicle price reduced per year
	public double PriceReducedPerYearCalculation(VehicleDetails vehicle) {
		double ActualPrice = vehicle.getPrice();
		double PriceReducedPerYear = ActualPrice*0.1;
		return PriceReducedPerYear;
	}

	
	// This method is used to calculate the how much used should pay as basic insurance
	@Override
	public double dvCalculation(String registrationNo) {
		VehicleDetails vehicle = vehicleDetailsRepository.findByRegistrationNo(registrationNo);
		double depreciationValue = PriceReducedPerYearCalculation(vehicle);
		double amount = (vehicle.getPrice() - (depreciationValue*vehicleAge(vehicle)))*0.05;
		
		return Math.abs(amount);
	}

	// this method is used to calculate how much user should pay as insurance according to the policy he selected
	@Override
	public double policyAmount(String registrationNo, String policyType) {
	
		double policyAmount = 0;
		if(policyType.equals("Thirdparty")) {
			policyAmount = dvCalculation(registrationNo);
		}
		else if(policyType.equals("Comprehensive")) {
			policyAmount = dvCalculation(registrationNo)*1.5;
		}
		return policyAmount;
	}

	//this method is used to calculate how much user gets if something happened to his vehicle.
	@Override
	public double insuredDeclaredValue(String registrationNo) {
		VehicleDetails vehicle = vehicleDetailsRepository.findByRegistrationNo(registrationNo);
		double depreciationValue = PriceReducedPerYearCalculation(vehicle);
		double insuredDeclaredValue = (vehicle.getPrice() - (depreciationValue*vehicleAge(vehicle)));
		
		return Math.abs(insuredDeclaredValue);
	}
	
	@Override
	public int savePolicy(Policy policy) {
		Policy savedPolicy =policyRepo.save(policy);
		return savedPolicy.getId();
	}
	
	
	

	
}
