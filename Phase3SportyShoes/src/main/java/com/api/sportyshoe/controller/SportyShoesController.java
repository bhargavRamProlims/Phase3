package com.api.sportyshoe.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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


	@GetMapping("/changePassword")
	public String changePass( String password, String retype_password) {

		if(password.equals(retype_password)) {
			try {
				String path = "src/main/resources/application.properties";
				Scanner scan = new Scanner(new File(path));
				StringBuffer buffer = new StringBuffer();
				while (scan.hasNextLine()) {
					buffer.append(scan.nextLine()+System.lineSeparator());
				}
				String fileContents = buffer.toString();
				scan.close();
				String oldPass = fileContents.substring(235,271);
				String newPass = "spring.security.user.password = "+password;
				fileContents = fileContents.replaceAll(oldPass, newPass);
				FileWriter writer = new FileWriter(path);
				writer.append(fileContents);
				writer.flush();

				Scanner newScan = new Scanner(new File(path));
				StringBuffer newBuffer = new StringBuffer();
				while (newScan.hasNextLine()) {
					newBuffer.append(newScan.nextLine()+System.lineSeparator());
				}
				String newfileContents = buffer.toString();
				System.out.println(newfileContents);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
			return "the new password is "+password;
		}
		else {
			return "Change Password is aborted";
		}
	}

	@PostConstruct
	public void repo() {
		service.createSportyShoes(new SportyShoes("Jim","Nike","Running","10-10-2020"));
		service.createSportyShoes(new SportyShoes("Jimmy","Adidas","Basket-Ball","11-10-2020"));
		service.createSportyShoes(new SportyShoes("Sam","Nike","Football","11-10-2020"));
		service.createSportyShoes(new SportyShoes("John","Adidas","Running","12-10-2020"));
		service.createSportyShoes(new SportyShoes("Jim","Adidas","Tennis","15-10-2020"));
		service.createSportyShoes(new SportyShoes("Jimmy","Adidas","Badminton","16-10-2020"));
		service.createSportyShoes(new SportyShoes("Sam","Adidas","Running","18-10-2020"));
		service.createSportyShoes(new SportyShoes("John","Adidas","Football","18-10-2020"));
		service.createSportyShoes(new SportyShoes("Sunny","Nike","Running","18-10-2020"));
		service.createSportyShoes(new SportyShoes("John","Adidas","Basket-Ball","19-10-2020"));
		service.createSportyShoes(new SportyShoes("Sam","Adidas","Tennis","19-10-2020"));
		service.createSportyShoes(new SportyShoes("Tim","Nike","Running","19-10-2020"));
		service.createSportyShoes(new SportyShoes("Timmy","Adidas","Tennis","20-10-2020"));
		service.createSportyShoes(new SportyShoes("Timmy","Nike","Badminton","20-10-2020"));
		service.createSportyShoes(new SportyShoes("Sunny","Adidas","Running","21-10-2020"));
		service.createSportyShoes(new SportyShoes("Tom","Adidas","Football","21-10-2020"));
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
