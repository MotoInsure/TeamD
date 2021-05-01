package com.ibm.motoInsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.motoInsure.entity.Admin;
import com.ibm.motoInsure.repository.AdminRepository;
/**
 * <p>This class is implementation of Admin service class operations</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired 
	private AdminRepository ar;
	/**
	 * @param admin
	 * @return adminId
	 */
	@Override
	public int addAdmin(Admin admin) {
		ar.save(admin);
		return admin.getId();
	}

}
