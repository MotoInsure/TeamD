package com.ibm.motoInsure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.EncodeDecode.Encryption;
import com.ibm.motoInsure.Exception.InvalidPolicyException;
import com.ibm.motoInsure.Exception.InvalidUserException;
import com.ibm.motoInsure.bean.Login;
import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.User;
import com.ibm.motoInsure.entity.VehicleDetails;
import com.ibm.motoInsure.repository.PolicyRepository;
import com.ibm.motoInsure.repository.UserRepository;
import com.ibm.motoInsure.repository.VehicleDetailsRepository;
/**
 * <p>This class is implementation of user service class operations</p>
 * @author Jai Baheti
 * @coauthor Theres Thomas
 * @since 18-04-2021
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private PolicyRepository pr;
	@Autowired
	private VehicleDetailsRepository vr;
	
	public User getUserById(int userId) {
		return ur.findById(userId).get();
	}
	
	@Override
	public int addPolicyToUser(int userId, int policyId) throws InvalidUserException {
		User u = ur.findById(userId).orElseThrow(()->new InvalidUserException("Invalid User")); 
		Policy p = pr.findById(policyId).get();		
		p.setUser(u);	
		ur.save(u);
		return u.getId();
	}
	@Override
	public int addUserVehicle(int id, String registrationNo) throws InvalidUserException {
		User u = ur.findById(id).orElseThrow(()->new InvalidUserException("Invalid User."));
		VehicleDetails vd = vr.findByRegistrationNo(registrationNo);
		System.out.println(vd);
		u.getVehiclesDetails().add(vd);
		ur.save(u);		
		return u.getId();
	}
	@Override
	public User validate(Login login) {
		Encryption encrypter = Encryption.getEncrypter();
		login.setPassword(encrypter.EncodePassword(login.getPassword()));
		return ur.findByEmailAndPassword(login.getemail(), login.getPassword());
	}
	@Override
	public int addUser(User user) {
		Encryption encrypter = Encryption.getEncrypter();
		user.setPassword(encrypter.EncodePassword(user.getPassword()));
		ur.save(user);
		return user.getId();
	}
	@Override
	public User getUser(String name) {
		User u =ur.findByUserName(name);
		return u;
	}
	@Override
	public User forgotPassword(String email) throws InvalidUserException {
		User u = getUserByEmail(email);
		System.out.println(u);
		if(u == null) {
			throw new InvalidUserException("Invalid user.");
		}
		else {
			return u;
		}		
	}
	@Override
	public User getUserByEmail(String email) {
		return ur.findByEmail(email);		
	}
	

}
