package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.AbstractUser;

public interface IUserRepository extends JpaRepository<AbstractUser,Long>{

	AbstractUser findByAddress(String city);

	AbstractUser findById(Integer addressId);

}
