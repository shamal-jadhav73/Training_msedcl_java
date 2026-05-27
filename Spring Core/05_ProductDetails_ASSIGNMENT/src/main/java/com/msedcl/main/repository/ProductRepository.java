package com.msedcl.main.repository;

import java.util.List;


import com.msedcl.main.entity.Product;

public interface ProductRepository {
	
	List<Product> getProductByName(String name);
	Product addNewProduct(Product product);

}
