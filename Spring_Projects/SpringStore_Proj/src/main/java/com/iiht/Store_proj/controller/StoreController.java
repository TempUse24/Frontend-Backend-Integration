package com.iiht.Store_proj.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.Store_proj.entity.Apples;
import com.iiht.Store_proj.entity.Bread;
import com.iiht.Store_proj.entity.Chocolates;
import com.iiht.Store_proj.entity.Eggs;
import com.iiht.Store_proj.entity.Milk;
import com.iiht.Store_proj.repository.AppleRepo;
import com.iiht.Store_proj.repository.BreadRepo;
import com.iiht.Store_proj.repository.ChocoRepo;
import com.iiht.Store_proj.repository.EggRepo;
import com.iiht.Store_proj.repository.MilkRepo;

@RestController
@RequestMapping("/store/api")
public class StoreController {
	
	@Autowired
	EggRepo eggrepo;
	@Autowired
	MilkRepo milkrepo;
	@Autowired
	ChocoRepo chocorepo;
	@Autowired
	AppleRepo applerepo;
	@Autowired
	BreadRepo breadrepo;
	
	@GetMapping
	@RequestMapping(path="/get")
	public ResponseEntity<List<Object>> getProduct(){
		
		List<Eggs> getEgg=eggrepo.findAll();
		List<Milk> getMilk=milkrepo.findAll();
		HashSet<Milk> setMilk=new HashSet<>();
		for(Milk m: getMilk)
			setMilk.add(m);
		List<Chocolates> getchoco=chocorepo.findAll();
		List<Apples> getapple=applerepo.findAll();
		List<Bread> getbread=breadrepo.findAll();
		Queue<Bread> setbread= new LinkedList<>(getbread);
		List<Object> products=new ArrayList<>();
		products.add(getEgg);
		products.add(setMilk);
		products.add(getchoco);
		products.add(getapple);
		products.add(setbread);
		return new ResponseEntity<List<Object>>(products,HttpStatus.OK);
	}

}
