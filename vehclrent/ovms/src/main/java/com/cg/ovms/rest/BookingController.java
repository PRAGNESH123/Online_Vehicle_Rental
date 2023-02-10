package com.cg.ovms.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.service.IBookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private IBookingService bookingService;

	@GetMapping("/getBooking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@GetMapping("/BookingById/{bookingId}")
	public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
		return bookingService.getBookingsById(bookingId);
	}

	/*
	 * @PostMapping public Booking addBooking(@RequestBody Booking booking) { return
	 * bookingService.addBooking(booking); }
	 */

	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
		bookingService.addBooking(booking);
		return ResponseEntity.ok("Added booking");
	}

	@PostMapping(value = "/addNewBookingByUserId/{id}", consumes = { "application/json" })
	public Booking addBooking(@RequestBody Booking booking, @PathVariable Long id) {
		return bookingService.addBooking(booking, id);
	}

	@DeleteMapping("/DeleteBookingById/{bookingId}")
	public void deleteBooking(@PathVariable Long bookingId) {
		bookingService.cancelBookingById(bookingId);
	}

	@GetMapping("/BookingByVehicleId/{vehicleId}")
	public Optional<Booking> getBookingByVehicleId(@PathVariable Long vehicleId) {
		return bookingService.viewBookingByVehicle(vehicleId);
	}

}