package com.ibm.motoInsure.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.Vehicle;
/**
 * <p>This interface is for vehicle without regNo data storage and retrieval</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	public List<Vehicle> findByType(String type);
		
}
