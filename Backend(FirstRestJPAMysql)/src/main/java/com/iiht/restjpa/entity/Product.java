package com.iiht.restjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product3")
public class Product {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long productId;
	 private String brand;
	  private String description;
	  private double qty;
	  private double price;
	  
}
