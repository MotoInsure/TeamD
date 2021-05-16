/**
 * This program implements an application that
 * creates a user_details table with 
 * OneToOne relationship with Policy
 * and OneToMany relationship with VehicleDetails
 * 
 * @author Jai Baheti
 * @version 1.0
 * @since 2021-04-24
 */
package com.ibm.motoInsure.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>This class implements User entity and provides getters and setters methods</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
@Entity
@Table(name="user_details")
@SequenceGenerator(name="userseq", sequenceName="seq_user", initialValue =101)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
	@Column(name="user_id")
	private int id;
	private String userName;
	@Column(name="user_contact", length=10, unique=true)	
	private double phoneNo;
	private String password;
	@Column(unique=true)
	private String email;
	private String state;
	private String city;
	
	
	
	@OneToMany
	@JoinTable(name="user_vehicle",
			joinColumns= @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="vehicle_id"))
	
	private List<VehicleDetails>vehiclesDetails = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<VehicleDetails> getVehiclesDetails() {
		return vehiclesDetails;
	}
	public void setVehiclesDetails(List<VehicleDetails> vehiclesDetails) {
		this.vehiclesDetails = vehiclesDetails;
	}
	
	
	
}
