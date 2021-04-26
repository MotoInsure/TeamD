package com.ibm.motoInsure.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class VehicleDetails {
	
	private String type;
	private String brand;
	private String model;
	private LocalDate purchasingYear;
	private double price;
}
