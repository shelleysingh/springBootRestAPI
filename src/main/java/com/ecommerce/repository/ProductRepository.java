package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.to.Product;

//Using an interface to pass the Product class and the primary key type which is Integer
//JpaRepository gives us methods to use: save(), findOne(), findAll(), count(), delete() etc
public interface ProductRepository extends JpaRepository<Product, Integer> {

}