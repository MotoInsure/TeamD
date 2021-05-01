package com.ibm.motoInsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.Admin;
/**
 *<p>This interface is for admin data storage and retrieval</p>
 * @author Jai Beheti
 * @since 18-04-2021
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {


}
