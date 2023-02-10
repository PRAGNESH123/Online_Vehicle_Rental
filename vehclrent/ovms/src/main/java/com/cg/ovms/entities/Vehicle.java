package com.cg.ovms.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="Vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleNumber;
	private String type;
	private String category;
	private String description;
	private String location;
	private Integer capacity;
	private double chargesPerDay;
	
	//unidirectional
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="driverId")
	private Driver driver;
	
	//bidirectional
	@JsonBackReference
	@OneToMany(mappedBy="vehicle",cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
}
