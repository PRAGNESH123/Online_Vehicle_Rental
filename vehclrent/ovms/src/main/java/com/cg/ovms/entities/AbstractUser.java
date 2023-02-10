package com.cg.ovms.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String userType;

	// Unidirectional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_Id")
	private Address address;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
	

}
