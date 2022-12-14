package com.food.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantid;
	@Size(min = 3, max = 15, message = "Restaurantname should contain atleast 3 letters and atmost 12 letter")
	private String restaurantname;
	@Size(min = 3, max = 15, message = "Managername should contain atleast 3 letters and atmost 12 letter")
	private String managername;
	@Size(min = 3, max = 15, message = "Contactname should contain atleast 3 letters and atmost 12 letter")
	private String contactname;
	@OneToOne(cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itemlist=new ArrayList<>();
}
