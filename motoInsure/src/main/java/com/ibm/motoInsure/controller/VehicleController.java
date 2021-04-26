package com.ibm.motoInsure.controller;

import java.util.Date;
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

@RestController
@RequestMapping(value="/vehicle")
public class VehicleController {
	
	private Map<String, String> vehicles;
	@Autowired
	private VehicleService vs;
	
	@PostMapping(value="/addVehicle", consumes="application/json")
	public String addVehicle(@RequestBody Vehicle vehicle) {
		vs.addVehicle(vehicle);
		return "Vehicle added";
	}
	
	@GetMapping(value="/getVehicle/{type}")
	public List getBrand(@PathVariable String type) {
		return vs.getBrand(type);
	}
	@GetMapping(value="/getVehicle/{type}/{brand}", produces="application/json")
	public Set<String> getModel(@PathVariable String brand) {
		return vs.getModel(brand);
	}
	@GetMapping(value="/getVehicle/{type}/{brand}/{model}", produces="application/json")
	public Set<String> getFuelType(@PathVariable String model) {
		return vs.getFuelType(model);
	}
	
	@GetMapping(value="/getVehicle/{type}/{brand}/{model}/{fuelType}", produces="application/json")
	public Set<String> getVariant(@PathVariable String fuelType, @PathVariable String brand) {
		return vs.getVariant(fuelType, brand);
	}
	@GetMapping(value="/getVehicle/{type}/{brand}/{model}/{fuelType}/{variant}", produces="application/json")
	public Set<Date> getPurchasedYear(@PathVariable String variant) {
		return vs.getPurchasedYear(variant);
	}
	
	
	
}
