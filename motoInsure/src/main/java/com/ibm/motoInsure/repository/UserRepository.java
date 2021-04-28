package com.ibm.motoInsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.motoInsure.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {

}
