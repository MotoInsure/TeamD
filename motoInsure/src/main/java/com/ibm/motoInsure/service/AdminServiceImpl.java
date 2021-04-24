package com.ibm.motoInsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Admin;
import com.ibm.motoInsure.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired 
	private AdminRepo ar;
	
	@Override
	public int addAdmin(Admin admin) {
		ar.save(admin);
		return admin.getId();
	}

}
