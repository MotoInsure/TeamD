package com.ibm.motoInsure.entity;

import java.time.LocalDate;


import javax.persistence.*;


@Entity
@Table(name="global_vehicles")

public class VehicleDetails {
	@Id
	private String registrationNo;
	private String type;
	private String brand;
	private String model;
	private String variant;
	private String fuelType;
	private LocalDate purchasingYear;
	private double price;
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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
