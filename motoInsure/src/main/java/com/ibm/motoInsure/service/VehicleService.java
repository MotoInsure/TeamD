package com.ibm.motoInsure.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;

@Service
public interface VehicleService {
	
	int addVehicle(Vehicle vehicle);
	List getBrand(String type);
	Set<String> getModel(String Brand);
	Set<String> getFuelType(String model);
	Set<String> getVariant(String fuelType, String brand);
	Set<LocalDate> getPurchasedYear(String variant);

}
