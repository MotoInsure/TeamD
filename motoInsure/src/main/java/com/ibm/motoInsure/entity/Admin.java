package com.ibm.motoInsure.entity;

import javax.persistence.*;
/**
 * <p>This class implements admin entity provides getters and setters methods</p>
 * @author Shruti Mittal
 * @since 18-04-2021
 *
 */

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
