package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Product;

public interface ProductService {

	List<Product> getProductByName(String name);
	Product addNewProduct(Product product);

}
