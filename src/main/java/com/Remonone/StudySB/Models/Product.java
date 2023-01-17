package com.Remonone.StudySB.Models;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document("product")
public class Product {
	
	@Autowired
	private AmazonS3 amazonS3;
	@Value("${AWS.Bucket}")
	private String bucket;
	
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
	
	private void uploadImage(MultipartFile image) throws AmazonServiceException, SdkClientException, IOException {
		ObjectMetadata data = new ObjectMetadata();
	    data.setContentType(image.getContentType());
	    data.setContentLength(image.getSize());
		amazonS3.putObject(bucket, "products/images/" + image.getOriginalFilename(), image.getInputStream(), data);
	}
	
	public Product(String name, String[] description, float price, float rating, MultipartFile[] images) { //WIP
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		try {
			for(int i = 0; i < images.length; i++) {
				uploadImage(images[i]);
				this.links.add("products/images/"+ images[i].getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return String.format("Product[id='%s', name='%s']", id, name);
	}
}
