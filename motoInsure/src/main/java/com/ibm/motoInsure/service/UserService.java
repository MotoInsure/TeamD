package com.ibm.motoInsure.service;

import com.ibm.motoInsure.bean.Login;
import com.ibm.motoInsure.entity.User;

public interface UserService {
	int addUser(User user);
	String forgotPassword(String uname);
	int addPolicyToUser(int id,int policyId);
	int addUserVehicle(int id,String registrationNo);
	User validate(Login login);
}
