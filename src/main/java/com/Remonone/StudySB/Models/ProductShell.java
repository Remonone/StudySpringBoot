package com.Remonone.StudySB.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductShell {
	@JsonProperty("name")
	public String name;
	@JsonProperty("description")
	public String[] description;
	@JsonProperty("price")
	public float price;
	@JsonProperty("rating")
	public float rating;
	
	@Override
	public String toString() {
		return String.format("Product[name='%s']", name);
	}
	
	@Component
    public static class StringToProductConverter implements Converter<String, Product> {

        @Autowired
        private ObjectMapper objectMapper;
        
        @Override
        public Product convert(String source) {
            try {
            	return objectMapper.readValue(source, Product.class);
            } catch(Exception e) {
            	e.printStackTrace();
            }
            return null;
        }

    }
}
