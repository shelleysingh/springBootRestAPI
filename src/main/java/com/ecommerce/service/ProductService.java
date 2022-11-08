package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.ProductRepository;
import com.ecommerce.to.Product;

//@Service annotation is used to mark the class as a service class
@Service
public class ProductService {
	// @Autowired annotation is used to inject the ProductRepository dependency
	@Autowired
	private ProductRepository repo;

	// listAll() method returns a list of all the products in the database
	public List<Product> listAll() {
		return repo.findAll();
	}

	// save() method saves the product passed to it
	public void save(Product product) {
		repo.save(product);
	}

	// get() method returns the product with the given id
	public Product get(Integer id) {
		return repo.findById(id).get();
	}

	// delete() method deletes the product with the given id
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
