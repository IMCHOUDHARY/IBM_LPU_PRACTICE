package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public Product findById(Integer id);
	public void saveOrUpdateProduct(Product product);
}
