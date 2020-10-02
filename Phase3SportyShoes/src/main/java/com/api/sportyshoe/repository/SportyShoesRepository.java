package com.api.sportyshoe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sportyshoe.model.SportyShoes;

@Repository
public interface SportyShoesRepository extends JpaRepository<SportyShoes, Integer> {

	public List<SportyShoes> findByDate(String Date);
	public List<SportyShoes> findByCategory(String category);
	public List<SportyShoes> findByName(String CustomerName);
	public List<SportyShoes> findByProduct(String Product);
	public List<SportyShoes> findByCategoryAndDate(String Category,String Date);
}