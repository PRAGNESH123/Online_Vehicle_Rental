package com.cg.ovms.entities;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private Date bookingDate;
    private Date bookingFromDate;
    private Date bookingTillDate;
    private String bookingDescription;
    private String bookingStatus;
    private double totalCost;
    private double distance;
    private String payment;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private AbstractUser user;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    public void setUser(AbstractUser user) {
        this.user = user;
    }
}