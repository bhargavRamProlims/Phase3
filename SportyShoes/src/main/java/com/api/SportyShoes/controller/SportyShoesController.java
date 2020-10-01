package com.api.SportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.SportyShoes.exceptionHandler.SportyShoesException;
import com.api.SportyShoes.model.SportyShoes;
import com.api.SportyShoes.service.SportyShoesService;


@RestController
public class SportyShoesController {

	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/SportShoes")
	public SportyShoes createSportyShoes(@RequestBody SportyShoes sportyShoes) {
		return service.createSportyShoes(sportyShoes);
	}
	
	@GetMapping("/SportShoes")
	public List<SportyShoes> getAllSportyShoes(){
		return service.getAllSportyShoes();
	}
	
	@GetMapping("/SportShoes/{Id}")
	public ResponseEntity<SportyShoes> getSportyShoesById(@PathVariable int Id) {
		try {
			return new ResponseEntity<>(service.getSportyShoesById(Id),HttpStatus.OK);
		} catch(SportyShoesException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/SportShoes/Date/{Date}")
	public List<SportyShoes> getAllSportyShoesByDate(@PathVariable String Date){
		return service.getAllSportyShoesByDate(Date);
	}
	
	@GetMapping("/SportShoes/Name/{Name}")
	public List<SportyShoes> getAllSportyShoesByName(@PathVariable String Name){
		return service.getAllSportyShoesByName(Name);
	}
	
	@GetMapping("/SportShoes/Product/{Product}")
	public List<SportyShoes> getAllSportyShoesByEmailId(@PathVariable String Product){
		return service.getAllSportyShoesByProduct(Product);
	}
	
	@GetMapping("/SportShoes/Category/{Category}")
	public List<SportyShoes> getAllSportyShoesByCategory(@PathVariable String Category){
		return service.getAllSportyShoesByCategory(Category);
	}
	
	
}
