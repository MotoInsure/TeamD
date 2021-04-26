package com.ibm.motoInsure.entity;


import java.time.LocalDate;

import java.time.LocalDate;
//
import java.util.ArrayList;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_details")
@SequenceGenerator(name="vehicleseq", sequenceName="seq_vehicle", initialValue =1001)
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicleseq")
	@Column(name="vehicle_id")
	private int id;
	private String type;
	private String brand;
	private String model;
	private String variant;
	private String fuelType;
	private LocalDate purchasingYear;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public LocalDate getPurchasingYear() {
		return purchasingYear;
	}
	public void setPurchasingYear(LocalDate purchasingYear) {
		this.purchasingYear = purchasingYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
