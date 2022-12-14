package com.food.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;

	private LocalDateTime orderdate;
	private String orderstatus;
	@ManyToOne(cascade = CascadeType.ALL)
	private Foodcart cart;	

}
