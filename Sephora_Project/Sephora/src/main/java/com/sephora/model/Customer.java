package com.sephora.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@Pattern(regexp="^[A-Za-z]+$",message="Invalid Firstname")
	@Size(min=3, message="The first name should contains atleast 3 characters")
	private String firstName;
	
	@Pattern(regexp="^[A-Za-z]+$",message="Invalid Lastname")
	@Size(min=3, message="The last name should contains atleast 3 characters")
	private String lastName;
	
	@Column(unique = true)
	@Email(message="Email not in correct format")
	private String email;
	
	@Size(min=10,max=10,message="Mobile number containes only digits or It containes only 10 digits.")
	private String phoneNumber;
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=])(?=\\S+$).{6,}$",message = "Password must meet complexity requirements")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	private String password;
	
	@NotNull(message="Role can not be not null.")
	private String role;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Address> addresses;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Orders> orders;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Payments> payments;

}