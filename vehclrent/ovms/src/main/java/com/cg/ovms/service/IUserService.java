package com.cg.ovms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.exceptionhandling.exceptiion.EmptyInputException;
import com.cg.ovms.repository.IUserRepository;

@Service
public class IUserService {
	@Autowired
	private IUserRepository userRepository;

	// Implementation to retrieve all users from database
	public List<AbstractUser> getAllUsers() {
		return userRepository.findAll();
	}

	// Implementation to add the users
	/*
	 * public AbstractUser addUser(AbstractUser user) { return
	 * userRepository.save(user); }
	 */

	public AbstractUser addUser(AbstractUser user) {
		if((user.getFirstName().isEmpty()|| user.getFirstName().length()==0) && (user.getLastName().isEmpty()|| user.getLastName().length()==0)
				&&(user.getPassword().isEmpty()|| user.getPassword().length()==0))
		{
			throw new EmptyInputException();
		}
		

		return userRepository.save(user);
	}

	// Implementation to retrieve address by the addressId from the database
	public AbstractUser getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	// Implementation to retrieve address by city from the database
	/*public AbstractUser findByAddress(String city) {
		return userRepository.findByAddress(city);
	}*/

	public AbstractUser getAddressByCity(String city) {
		return userRepository.findByAddress(city);
	}
}
