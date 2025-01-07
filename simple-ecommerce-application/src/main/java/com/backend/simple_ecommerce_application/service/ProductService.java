package com.backend.simple_ecommerce_application.service;

import com.backend.simple_ecommerce_application.model.Product;
import com.backend.simple_ecommerce_application.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProdRepo repo;

    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        products.forEach(product -> System.out.println(product)); // Debug log
        return products;

    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }
}
