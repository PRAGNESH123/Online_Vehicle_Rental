package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.Address;

public interface IAddressRepository extends JpaRepository<Address, String>{

}
