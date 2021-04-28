package com.ibm.motoInsure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.bean.Login;
import com.ibm.motoInsure.entity.Policy;
import com.ibm.motoInsure.entity.User;
import com.ibm.motoInsure.entity.VehicleDetails;
import com.ibm.motoInsure.repository.PolicyRepository;
import com.ibm.motoInsure.repository.UserRepository;
import com.ibm.motoInsure.repository.VehicleDetailsRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private PolicyRepository pr;
	@Autowired
	private VehicleDetailsRepository vr;
	@Override
	public int addPolicyToUser(int userId, int policyId) {
		User u = ur.findById(userId).get(); 
		Policy p = pr.findById(policyId).get();		
		u.setPolicy(p);	
		ur.save(u);
		return u.getId();
	}
	@Override
	public int addUserVehicle(int id, String registrationNo) {
		User u = ur.findById(id).get();
		VehicleDetails vd = vr.findByRegistrationNo(registrationNo);
		System.out.println(vd);
		u.getVehiclesDetails().add(vd);
		ur.save(u);		
		return u.getId();
	}
	@Override
	public User validate(Login login) {
		return ur.findByUserNameAndPassword(login.getUsername(), login.getPassword());
	}

}
