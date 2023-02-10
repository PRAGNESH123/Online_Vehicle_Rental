package com.cg.ovms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IVehicleRepository;

@Service
public class IVehicleService {
	@Autowired
	private IVehicleRepository vehicleRepository;

	public List<Vehicle> viewAllVehicles() {
		return vehicleRepository.findAll();
	}

	public Optional<Vehicle> viewBookingByVehicle(Long vehicleId) {
		// TODO Auto-generated method stub
		return vehicleRepository.findById(vehicleId);
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

}
