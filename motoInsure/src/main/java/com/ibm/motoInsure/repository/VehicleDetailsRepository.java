package com.ibm.motoInsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.VehicleDetails;

public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {
	VehicleDetails findByRegistrationNo(String registrationNo);
}
