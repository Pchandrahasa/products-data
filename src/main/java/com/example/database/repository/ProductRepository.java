package com.example.database.repository;

import com.example.database.model.Product;
import java.util.*;

public interface ProductRepository {


    ArrayList<Product> getProducts();

    Product productById(int productId);

    Product addProduct(Product product);

    Product updateProduct(Product product,int productId);

    void deleteProduct(int productId);
}
