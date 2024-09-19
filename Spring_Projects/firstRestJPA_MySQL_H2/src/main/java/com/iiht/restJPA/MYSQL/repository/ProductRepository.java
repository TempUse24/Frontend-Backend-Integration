package com.iiht.restJPA.MYSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.restJPA.MYSQL.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
