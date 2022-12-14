package com.food.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catid;
	@Size(min = 3, max = 15, message = "Categoryname should contain atleast 3 letters and atmost 12 letter")
	private String categoryname;
	@OneToMany(cascade = CascadeType.ALL)
	private Item item;
}
