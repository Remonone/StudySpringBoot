package com.Remonone.StudySB.Models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("product")
public class Product {
		
	@Id
	private String id; 
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String[] description;
	@JsonProperty("price")
	private float price;
	@JsonProperty("rating")
	private float rating;
	@JsonProperty("images")
	private ArrayList<String> links;
	
	public Product(String name, String[] description, float price, float rating, ArrayList<String> links) { //WIP
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.links = links;
	}
	
	@Override
	public String toString() {
		return String.format("Product[id='%s', name='%s']", id, name);
	}
	
	
}
