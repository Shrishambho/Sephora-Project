package com.sephora.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	
	@NotNull(message="City name can not be not null.")
	private String city;
	
	@NotNull(message="District name can not be not null.")
	private String district;
	
	@NotNull(message="State name can not be not null.")
	private String state;
	
	@NotNull(message = "ZIP code cannot be null")
	private Integer zipCode;
	 
	@ManyToOne
	private Customer customer;
}
