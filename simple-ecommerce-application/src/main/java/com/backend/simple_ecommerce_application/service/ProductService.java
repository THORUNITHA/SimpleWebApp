package com.backend.simple_ecommerce_application.service;

import com.backend.simple_ecommerce_application.model.Product;
import com.backend.simple_ecommerce_application.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public byte[] getImageById(int id) {
        Product p=repo.findById(id).get();
        return p.getImageData();
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        Product p1=repo.findById(id).get();
         repo.delete(p1);
    }

    public List<Product> searchProduct(String keyword) {
        return  repo.searchProducts(keyword);
    }
}
