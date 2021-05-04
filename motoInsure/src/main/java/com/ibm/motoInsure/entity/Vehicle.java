package com.ibm.motoInsure.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * <p>This class implements vehicle entity without registrationNo for searching purpose only and provides getters and setters methods</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
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
