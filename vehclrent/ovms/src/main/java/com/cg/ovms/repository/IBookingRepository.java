package com.cg.ovms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long>{

	Optional<Booking> findById(Long bookingId);
	

}
