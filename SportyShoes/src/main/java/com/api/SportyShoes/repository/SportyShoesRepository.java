package com.api.SportyShoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.SportyShoes.model.SportyShoes;

@Repository
public interface SportyShoesRepository extends JpaRepository<SportyShoes, Integer> {

	public List<SportyShoes> findByDateofpurchase(String DateOfPurchase);
	public List<SportyShoes> findByCategory(String category);
	public List<SportyShoes> findByCustomerName(String CustomerName);
	public List<SportyShoes> findByProduct(String Product);
}
