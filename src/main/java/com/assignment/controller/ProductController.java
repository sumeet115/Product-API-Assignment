package com.assignment.controller;

import java.util.List;
import java.util.Optional;

import com.assignment.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.service.ProductService;

@RestController
@RequestMapping("/products")
@Tag(name = "Product API", description = "API for managing products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "Fetch all products from the database")
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> productList = productService.findAll();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    @Operation(summary = "Create product", description = "Create a new product in the database")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return ResponseEntity.ok(productService.create(product));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Fetch a single product by the ID")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        Optional<Product> product = productService.findById(id);
        return ResponseEntity.of(product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Delete a product by the ID")
    public ResponseEntity deleteProductById(@PathVariable Long id) {

        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.delete(product.get());
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.ok("Product not found");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Update an existing product by their ID")
    public ResponseEntity<Product> updateUser(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productService.updateProduct(id, productDetails);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
