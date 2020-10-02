package com.api.sportyshoe.service;

import java.util.List;

import com.api.sportyshoe.exceptionHandler.SportyShoesException;
import com.api.sportyshoe.model.SportyShoes;

public interface SportyShoesService {
	
	public SportyShoes createSportyShoes(SportyShoes sportyShoes);
	public SportyShoes getSportyShoesById(int Id) throws SportyShoesException;
	public List<SportyShoes> getAllSportyShoes();
	public List<SportyShoes> getAllSportyShoesByDate(String Date);
	public List<SportyShoes> getAllSportyShoesByName(String Name);
	public List<SportyShoes> getAllSportyShoesByProduct(String Product);
	public List<SportyShoes> getAllSportyShoesByCategory(String Category);
	public List<SportyShoes> getAllSportyShoesByCategoryAndDate(String Category,String Date);

}