package com.example.database.controller;


import java.util.*;
import com.example.database.model.Product;
import com.example.database.model.Review;
import com.example.database.repository.ReviewJpaRepository;
import com.example.database.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;


    private ReviewJpaRepository reviewJpaRepository;

    @GetMapping("/products")
    public ArrayList<Product> products(){
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product productById(@PathVariable("productId") int productId){
        return productService.productById(productId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("productId") int productId) {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);


    }
}
