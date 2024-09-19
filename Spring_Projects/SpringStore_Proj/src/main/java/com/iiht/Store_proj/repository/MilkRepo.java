package com.iiht.Store_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.Store_proj.entity.Milk;

@Repository
public interface MilkRepo extends JpaRepository<Milk,Long>{

}
