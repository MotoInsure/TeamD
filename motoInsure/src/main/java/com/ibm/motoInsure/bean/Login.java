package com.ibm.motoInsure.bean;
/**
 * <p>This class is login POJO</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
public class Login {
	private String email;
	private String password;
	
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
