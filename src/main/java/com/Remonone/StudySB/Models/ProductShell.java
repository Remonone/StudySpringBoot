package com.Remonone.StudySB.Models;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductShell {
	@JsonProperty("name")
	public String name;
	@JsonProperty("description")
	public String[] description;
	@JsonProperty("price")
	public float price;
	@JsonProperty("rating")
	public float rating;
	@JsonProperty("images")
	public MultipartFile[] imagesFiles;
}
