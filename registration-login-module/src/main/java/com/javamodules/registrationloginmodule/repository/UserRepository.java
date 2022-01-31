package com.javamodules.registrationloginmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javamodules.registrationloginmodule.model.User;

//Exposes DB CRUD operations on entitity, Long is the primary key type 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
