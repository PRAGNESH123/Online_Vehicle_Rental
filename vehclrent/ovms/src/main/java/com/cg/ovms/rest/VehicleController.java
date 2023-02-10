package com.cg.ovms.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.service.IVehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	@Autowired
	private IVehicleService vehicleService;

	@GetMapping("/bookingByVehicleId/{vehicleId}")
	public Optional<Vehicle> getBookingByVehicleId(@PathVariable Long vehicleId) {
		return vehicleService.viewBookingByVehicle(vehicleId);
	}

	@GetMapping("/viewAllvehicles")
	public List<Vehicle> viewAllVehicles() {
		return vehicleService.viewAllVehicles();
	}

	@PostMapping("/addvehicles")
	public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.addVehicle(vehicle);
		return ResponseEntity.ok("vehicle added");
	}
}
