package com.ibm.motoInsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.User;
/**
 * <p>This interface is for user data storage and retrieval</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */

public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUserName(String name);
	User findByUserNameAndPassword(String name, String password);
}
