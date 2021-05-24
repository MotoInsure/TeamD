package com.ibm.motoInsure.entity;

import java.time.LocalDate;


import javax.persistence.*;

/**
 * <p>This class implements vehicle entity with registrationNo and provides getters and setters methods</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
@Entity
@Table(name="global_vehicles")

public class VehicleDetails {	
	@Id
	@GeneratedValue
	private int id;
	private String registrationNo;
	private String type;
	private String brand;
	private String model;
	private String variant;
	private String fuelType;
	private int purchasingYear;
	private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getPurchasingYear() {
		return purchasingYear;
	}
	public void setPurchasingYear(int purchasingYear) {
		this.purchasingYear = purchasingYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
