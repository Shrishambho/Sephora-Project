package com.sephora.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

@Entity
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@FutureOrPresent(message = "Order date must be today or in the future")
	private LocalDate date;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(mappedBy="orders",cascade=CascadeType.ALL)
	@JsonIgnore
	private Payments payments;
}
