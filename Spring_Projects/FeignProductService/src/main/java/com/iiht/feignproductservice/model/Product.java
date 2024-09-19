package com.iiht.feignproductservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//POJO
public class Product {
	
	Integer productId;
	String name;
	String category;
	String brand;
	double price;

}
