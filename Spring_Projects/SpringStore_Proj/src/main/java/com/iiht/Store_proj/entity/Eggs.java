package com.iiht.Store_proj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Eggs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eggId;
	private double cost;
	private int quantity;

}
