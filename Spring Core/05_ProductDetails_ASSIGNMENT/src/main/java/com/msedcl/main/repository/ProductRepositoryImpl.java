package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.msedcl.main.entity.Product;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private static final String ADD_NEW_PRODUCT = "INSERT INTO product_details(name,price) VALUES(?,?)";
	private static final String GET_PRODUCT_BY_NAME = "SELECT * FROM product_details WHERE name=?";
	private JdbcTemplate jdbcTemplate;

	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_PRODUCT_BY_NAME, (rs,row)->new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)), name);
	}

	@Override
	public Product addNewProduct(Product product) {
		// TODO Auto-generated method stub
		
		int rowsInserted = jdbcTemplate.update(ADD_NEW_PRODUCT, product.getName(), product.getPrice());

		if (rowsInserted > 0)
			return product;
		else
			return null;
		
	}

}
