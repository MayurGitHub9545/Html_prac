package com.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.Repository.ProductRepository;
import com.kit.entity.Product;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepository repository;

	 // save single product
	    public Product saveProduct(Product product) {
	        return repository.save(product);
	    }

	    // save multiple product
	    public List<Product> saveProducts(List<Product> products) {
	        return repository.saveAll(products);
	    }

	  
	    public List<Product> getProducts() {
	        return repository.findAll();
	    }

	    public Product getProductById(int pid) {
	        return repository.findById(pid).orElse(null);
	    }

	    

	    public String deleteProduct(int pid) {
	        repository.deleteById(pid);
	        return "product removed !! " + pid;
	    }

	    public Product updateProduct(Product product) {
	        Product existingProduct = repository.findById(product.getPid()).orElse(null);
	        existingProduct.setPname(product.getPname());
	        existingProduct.setPrice(product.getPrice());
	        return repository.save(existingProduct);
	    }


	

}
