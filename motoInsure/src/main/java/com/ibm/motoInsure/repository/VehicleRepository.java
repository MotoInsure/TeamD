package com.ibm.motoInsure.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	public List<Vehicle> findByType(String type);
		
}
