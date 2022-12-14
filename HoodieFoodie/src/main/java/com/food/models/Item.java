package com.food.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemid;
	@Size(min = 3, max = 12, message = "Itemname should contain atleast 3 letters and atmost 12 letter")
	private String itemname;
	@Min(value = 1, message = "quantity should be equal or greater than 1")
	private Integer quantity;
	@Min(value = 1, message = "quantity should be equal or greater than 1")
	private Double cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL)
	private List<Restaurant> restaurant;
}
