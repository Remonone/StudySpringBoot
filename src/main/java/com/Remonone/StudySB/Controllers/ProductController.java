package com.Remonone.StudySB.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Remonone.StudySB.Models.Product;
import com.Remonone.StudySB.Models.ProductShell;
import com.Remonone.StudySB.Services.AmazonService;
import com.Remonone.StudySB.Services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService products;
	@Autowired
	AmazonService amazonS3;
	@Value("${AWS.Bucket}")
	private String bucket;
	@Value("${AWS.Region}")
	private String region;
	
	@PostMapping(path = "/products", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public Product addProduct(@RequestParam(value = "file") MultipartFile[] images, @RequestPart(value = "product") ProductShell product) {
		ArrayList<String> links = new ArrayList<String>();
		for(int i = 0; i < images.length; i++) {
			amazonS3.putObject(images[i]);
			links.add("https://"+ bucket +".s3."+ region +".amazonaws.com/products/images/" + images[i].getOriginalFilename());
		}
		Product newProduct = new Product(product.name, product.description, product.price, product.rating, links);
		Product createdProduct = products.save(newProduct);
		return createdProduct;
	}
	
}
