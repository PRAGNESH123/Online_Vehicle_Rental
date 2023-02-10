package com.cg.ovms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
public class IBookingService {
	@Autowired
	private IBookingRepository bookingRepository;
	@Autowired
	private IUserRepository userRepository;
	
	public List<Booking> getAllBooking()
	{
		return bookingRepository.findAll();
	}

	// to retrieve all bookings by Id
	public Optional<Booking> getBookingsById(Long bookingId) {
		return bookingRepository.findById(bookingId);
	}

	// To add booking
	public Booking addBooking(Booking booking) {
		AbstractUser user = userRepository.findById(booking.getUser().getId());
		booking.setUser(user);
		return bookingRepository.save(booking);
	}
	
	//To add booking
	 @Transactional
	    public Booking addBooking(Booking booking, Long id) {
	       Optional<AbstractUser> user = userRepository.findById(id);

	       if(user.get().getBookings().size()  > 0){
	           user.get().getBookings().add(booking);
	       }
	       else{
	           List<Booking> bookingList = new ArrayList<Booking>();
	           bookingList.add(booking);
	           user.get().setBookings(bookingList);
	       }
	       
	       userRepository.save(user.get());
	       booking.setUser(user.get());

	       return bookingRepository.save(booking);
	    }
	

	// To cancel booking
	public void cancelBookingById(Long bookingId) {
		bookingRepository.deleteById(bookingId);
	}

	// To view list of bookings by bookingId
	public Optional<Booking> viewBooking(Long bookingId) {
		return bookingRepository.findById(bookingId);
	}

	// To view list of bookings by vehicleNumber
	public Optional<Booking> viewBookingByVehicle(Long vehicleId) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(vehicleId);
	}
}
