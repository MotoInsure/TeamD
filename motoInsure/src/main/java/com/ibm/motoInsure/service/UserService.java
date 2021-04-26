package com.ibm.motoInsure.service;

public interface UserService {
	int addPolicyToUser(int id,int policyId);
	int addUserVehicle(int id,String registrationNo);
}
