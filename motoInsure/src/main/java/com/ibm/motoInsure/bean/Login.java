package com.ibm.motoInsure.bean;
/**
 * <p>This class is login POJO</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
public class Login {
	private String username;
	private String password;
	
	
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
