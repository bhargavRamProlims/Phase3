package com.api.sportyshoe.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sportyshoe.exceptionHandler.SportyShoesException;
import com.api.sportyshoe.model.SportyShoes;
import com.api.sportyshoe.repository.SportyShoesRepository;
import com.api.sportyshoe.service.SportyShoesService;


@Service
public class SportyShoesServiceImpl implements SportyShoesService{

	@Autowired
	private SportyShoesRepository repository;
	
	
	@Override
	public SportyShoes createSportyShoes(SportyShoes sportyShoes) {
		return repository.save(sportyShoes);
	}

	@Override
	public SportyShoes getSportyShoesById(int Id) throws SportyShoesException {
		SportyShoes sportyShoes=null;
		try {
			if(Id<=0) {
				throw new SportyShoesException("ID cannot be zero or negative");
			}
			sportyShoes=repository.findById(Id).get();			
		} catch(NoSuchElementException e){
			throw new SportyShoesException("No data found with this ID");
		}
		
		return sportyShoes;
	}

	@Override
	public List<SportyShoes> getAllSportyShoes() {
		return repository.findAll();
	}

	@Override
	public List<SportyShoes> getAllSportyShoesByDate(String Date) {
		return repository.findByDate(Date);
	}

	@Override
	public List<SportyShoes> getAllSportyShoesByName(String Name) {
		return repository.findByName(Name);
	}

	@Override
	public List<SportyShoes> getAllSportyShoesByProduct(String Product) {
		return repository.findByProduct(Product);
	}

	@Override
	public List<SportyShoes> getAllSportyShoesByCategory(String Category) {
		
		return repository.findByCategory(Category);
	}

}