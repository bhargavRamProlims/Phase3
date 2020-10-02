package com.api.sportyshoe.controller;

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

import com.api.sportyshoe.exceptionHandler.SportyShoesException;
import com.api.sportyshoe.model.SportyShoes;
import com.api.sportyshoe.service.SportyShoesService;


@RestController
public class SportyShoesController {

	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/sportyshoe")
	public SportyShoes createSportyShoes(@RequestBody SportyShoes sportyShoes) {
		return service.createSportyShoes(sportyShoes);
	}
	
	@GetMapping("/sportyshoe")
	public List<SportyShoes> getAllSportyShoes(){
		return service.getAllSportyShoes();
	}
	
	@GetMapping("/sportyshoe/{Id}")
	public ResponseEntity<SportyShoes> getSportyShoesById(@PathVariable int Id) {
		try {
			return new ResponseEntity<>(service.getSportyShoesById(Id),HttpStatus.OK);
		} catch(SportyShoesException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/sportyshoe/Date/{Date}")
	public List<SportyShoes> getAllSportyShoesByDate(@PathVariable String Date){
		return service.getAllSportyShoesByDate(Date);
	}
	
	@GetMapping("/sportyshoe/Name/{Name}")
	public List<SportyShoes> getAllSportyShoesByName(@PathVariable String Name){
		return service.getAllSportyShoesByName(Name);
	}
	
	@GetMapping("/sportyshoe/Product/{Product}")
	public List<SportyShoes> getAllSportyShoesByEmailId(@PathVariable String Product){
		return service.getAllSportyShoesByProduct(Product);
	}
	
	@GetMapping("/sportyshoe/Category/{Category}")
	public List<SportyShoes> getAllSportyShoesByCategory(@PathVariable String Category){
		return service.getAllSportyShoesByCategory(Category);
	}
	
	
}
