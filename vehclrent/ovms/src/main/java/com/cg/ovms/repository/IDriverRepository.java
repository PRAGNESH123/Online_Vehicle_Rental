package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.Driver;

public interface IDriverRepository extends JpaRepository<Driver,Long> {

}
