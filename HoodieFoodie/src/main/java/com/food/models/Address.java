package com.food.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressid;
	@Size(min=3, max=10, message= "building name should contain atleast 3 letters and atmost 10 letter")
	private String buildingname;
	@Size(min=1, max=10, message= "streetno contains atleast 1 letter ")
	private String streetno;
	@NotNull(message="area should not be null")
	@NotBlank(message="area should not be blank")
	@NotEmpty(message="area should not be empty")
	private String area;
	@NotNull(message="city should not be null")
	@NotBlank(message="city should not be blank")
	@NotEmpty(message="city should not be empty")
	private String city;
	@NotNull(message="state should not be null")
	@NotBlank(message="state should not be blank")
	@NotEmpty(message="state should not be empty")
	private String state;
	@NotNull(message="country should not be null")
	@NotBlank(message="country should not be blank")
	@NotEmpty(message="country should not be empty")
	private String country;
	@Size(min=6, max=6, message= "pincode should be of length 6 digit")
	private String pincode;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;
	

}
