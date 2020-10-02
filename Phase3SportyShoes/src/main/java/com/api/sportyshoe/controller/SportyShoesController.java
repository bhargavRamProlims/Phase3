package com.api.sportyshoe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.api.sportyshoe.exceptionHandler.SportyShoesException;
import com.api.sportyshoe.model.SportyShoes;
import com.api.sportyshoe.service.SportyShoesService;


@RestController
public class SportyShoesController {

	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> errorMap;
	
	
	@PostConstruct
	public void repo() {
		service.createSportyShoes(new SportyShoes("Jim","Nike","Running","10-10-2020"));
		service.createSportyShoes(new SportyShoes("Jimmy","Adidas","Basket-Ball","11-10-2020"));
		service.createSportyShoes(new SportyShoes("Sam","Nike","Football","11-10-2020"));
		service.createSportyShoes(new SportyShoes("John","Adidas","Running","10-10-2020"));
		service.createSportyShoes(new SportyShoes("Jim","Adidas","Tennis","15-10-2020"));
		service.createSportyShoes(new SportyShoes("Jimmy","Adidas","Badminton","16-10-2020"));
		service.createSportyShoes(new SportyShoes("Sam","Adidas","Running","18-10-2020"));
		service.createSportyShoes(new SportyShoes("John","Adidas","Football","17-10-2020"));
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
	
	@GetMapping("/sportyshoe/Category/{Category}/Date/{Date}")
	public List<SportyShoes> getAllSportyShoesByCategoryAndDate(@PathVariable String Category, @PathVariable String Date){
		return service.getAllSportyShoesByCategoryAndDate(Category, Date);
	}
	
	
}
