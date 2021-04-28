package com.ibm.motoInsure.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;

@Service
public interface VehicleService {
	
	int addVehicle(Vehicle vehicle);
	List getBrand(String type);
	Set<String> getModel(String Brand);
	

}
