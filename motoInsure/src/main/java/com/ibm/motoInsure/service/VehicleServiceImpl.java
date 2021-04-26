package com.ibm.motoInsure.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.repository.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	List<Vehicle> vehicle_list = new ArrayList<>();
	@Autowired 
	private VehicleRepo vr;
	
	@Override
	public int addVehicle(Vehicle vehicle) {
		vr.save(vehicle);
		return vehicle.getId();
	}
	@Override
	public List getBrand(String type) {
		vehicle_list=vr.findByType(type);
		return vehicle_list;
	}
	@Override
	public Set<String> getModel(String Brand) {
		HashMap<String, Integer> hashmap = new HashMap();
		for (Vehicle vehicle : vehicle_list) 
			if(vehicle.getBrand().equalsIgnoreCase(Brand))
				hashmap.put(vehicle.getModel(),vehicle.getId());
		
		return hashmap.keySet();
		
	}
	
	@Override
	public Set<String> getFuelType(String model) {
		HashMap<String, Integer> hashmap = new HashMap();
		for (Vehicle vehicle : vehicle_list) 
			if(vehicle.getModel().equalsIgnoreCase(model))
				hashmap.put(vehicle.getFuelType(),vehicle.getId());
		
		return hashmap.keySet();
	}
	@Override
	public Set<String> getVariant(String fuelType, String brand) {
		HashMap<String, Integer> hashmap = new HashMap();
		for (Vehicle vehicle : vehicle_list)
			if(vehicle.getFuelType().equalsIgnoreCase(fuelType) && vehicle.getBrand().equalsIgnoreCase(brand))
				hashmap.put(vehicle.getVariant(),vehicle.getId());
		
		return hashmap.keySet();
	}
	@Override
	public Set<Date> getPurchasedYear(String variant) {
		HashMap<Date, Integer> hashmap = new HashMap();
		for (Vehicle vehicle : vehicle_list)
			if(vehicle.getVariant().equalsIgnoreCase(variant))
				hashmap.put(vehicle.getPurchasingYear(),vehicle.getId());
		
		return hashmap.keySet();
	}
	
	
}
