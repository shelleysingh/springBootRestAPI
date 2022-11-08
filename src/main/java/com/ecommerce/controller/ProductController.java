package com.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.ProductService;
import com.ecommerce.to.Product;

//@RestController - CREATE RESTful web services using Spring MVC
@RestController
public class ProductController {
	// @Autowired - Injects the ProductService dependency
	@Autowired
	private ProductService service;

	// @GetMapping - HTTP GET requests to /products are mapped to the list() method
	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	// @GetMapping - HTTP GET requests to /products/{id} are mapped to the get()
	// method
	// @PathVariable - bind a path variable with a method parameter
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	// @PostMapping - HTTP POST requests to /products are mapped to the add() method
	// @RequstBody - HttpRequest body to a transfer or domain object, enabling
	// automatic de-serialisation of the inbounds HttpRequest body onto a Java object
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		service.save(product);
	}

	// @PutMapping - HTTP PUT requests to /products/{id} are mapped to the update() method
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			// Product existingProduct = service.get(id);
			service.save(product);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// HTTP DELETE requests to /products/{id} are mapped to the delete() method
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
