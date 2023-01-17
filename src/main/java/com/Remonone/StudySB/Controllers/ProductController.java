package com.Remonone.StudySB.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Remonone.StudySB.Models.Product;
import com.Remonone.StudySB.Models.ProductShell;
import com.Remonone.StudySB.Services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService products;
	
	@PostMapping("/products")
	public Product addProduct(@ModelAttribute ProductShell product) {
		Product newProduct = new Product(product.name, product.description, product.price, product.rating, product.imagesFiles);
		System.out.println(product.toString());
		Product createdProduct = products.save(newProduct);
		return createdProduct;
	}
}
