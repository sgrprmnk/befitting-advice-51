package com.food.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	@Email(message = "Email should be valid")
	private String username;
	@Size(min = 4, max = 8, message = "password should contain atleast 4 letters and atmost 8 letters")
	private String password;
}
