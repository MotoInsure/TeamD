package com.ibm.motoInsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.VehicleDetails;
/**
 * <p>This interface is for vehicle with regNo data storage and retrieval</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {
	VehicleDetails findByRegistrationNo(String registrationNo);
}
