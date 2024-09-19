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
public class Milk {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long milkId;
	private double cost;
	private int quantity;
	private String brand;

}
