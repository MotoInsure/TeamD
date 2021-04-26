package com.ibm.motoInsure.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	List<Vehicle> vehicle_list = new ArrayList<>();
	@Autowired 
	private VehicleRepository vr;
	
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
	
	
}
