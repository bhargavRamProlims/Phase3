package com.api.sportyshoe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
public class SportyShoes {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String product;
	private String category;
	private String date;
	public SportyShoes(String name, String product, String category, String date) {
		super();
		this.name = name;
		this.product = product;
		this.category = category;
		this.date = date;
	}
	

}
