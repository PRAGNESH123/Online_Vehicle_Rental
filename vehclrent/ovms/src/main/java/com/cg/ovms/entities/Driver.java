package com.cg.ovms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer driverId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String licenseNumber;
	private String MobileNumber;
}
