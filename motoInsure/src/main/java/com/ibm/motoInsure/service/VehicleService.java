package com.ibm.motoInsure.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.entity.VehicleDetails;
/**
 *  <p>This service interface is for vehicle containing logic foradd and get operations</p>
 * @author Jai Baheti
 * @since 18-04-2021
 *
 */
@Service
public interface VehicleService {
	VehicleDetails getPrice(String registrationNo);
	
	
	
	
//	/**
//	 * 
//	 * @param vehicle
//	 * @return id
//	 */
//	
//	int addVehicle(Vehicle vehicle);
//	/**
//	 * 
//	 * @param type
//	 * @return list of vehicles
//	 */
//	List getBrand(String type);
//	/**
//	 * 
//	 * @param Brand
//	 * @return set of vehicles
//	 */
//	Set<String> getModel(String Brand);
//	

}
