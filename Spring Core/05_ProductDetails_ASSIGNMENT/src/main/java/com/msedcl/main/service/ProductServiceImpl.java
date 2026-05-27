package com.msedcl.main.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Product;

import com.msedcl.main.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	
	private  ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.getProductByName(name);
	}

	@Override
	public Product addNewProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.addNewProduct(product);
	}

}
