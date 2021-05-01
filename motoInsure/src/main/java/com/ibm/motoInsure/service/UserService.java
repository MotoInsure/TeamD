/** 
 * 
 */

package com.ibm.motoInsure.service;

import com.ibm.motoInsure.Exception.InvalidUserException;
import com.ibm.motoInsure.bean.Login;
import com.ibm.motoInsure.entity.User;
/**
 * <p>This service interface is for user containing logic for add and reset password operations</p>
 * @author Theres Thomas
 * @since18-04-2021
 * 
 *
 */
public interface UserService {
	int addUser(User user);
	String forgotPassword(String uname) throws InvalidUserException;
	int addPolicyToUser(int id,int policyId) throws InvalidUserException;
	int addUserVehicle(int id,String registrationNo) throws InvalidUserException;
	User validate(Login login);
}
