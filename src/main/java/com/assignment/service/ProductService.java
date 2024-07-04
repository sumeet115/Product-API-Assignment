package com.assignment.service;

import java.util.List;
import java.util.Optional;

import com.assignment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {

        List<Product> products = productRepository.findAll();
        return products;
    }

    public Optional<Product> findById(Long id) {

        return productRepository.findById(id);
    }

    public Product create(Product product) {

        return productRepository.save(product);
    }

    public void delete(Product product) {

        productRepository.delete(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }
        return null;
    }
}
