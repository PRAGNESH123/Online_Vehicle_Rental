package com.cg.ovms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

	//Vehicle findById(long vehicleId);

	Optional<Vehicle> findById(Long driverId);
}
