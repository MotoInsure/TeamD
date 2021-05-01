package com.ibm.motoInsure.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.entity.Vehicle;
import com.ibm.motoInsure.service.VehicleService;
/**
 * <p>This controller class provides view to methods available to vehicle</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
@RestController
@RequestMapping(value="/vehicle")
public class VehicleController {
	
	private Map<String, String> vehicles;
	@Autowired
	private VehicleService vs;
	/**
	 * 
	 * @param vehicle
	 * @return confirmation of vehicle addition
	 */
	
	@PostMapping(value="/addVehicle", consumes="application/json")
	public String addVehicle(@RequestBody Vehicle vehicle) {
		vs.addVehicle(vehicle);
		return "Vehicle added";
	}
	/**
	 * 
	 * @param vehicle_type
	 * @return brand
	 */
		
	@GetMapping(value="/getVehicle/{type}")
	public List getBrand(@PathVariable String type) {
		return vs.getBrand(type);
	}
	/**
	 * 
	 * @param brand
	 * @return model
	 */
	@GetMapping(value="/getVehicle/{type}/{brand}", produces="application/json")
	public Set<String> getModel(@PathVariable String brand) {
		return vs.getModel(brand);
	}
	
	
	
	
}
