package com.backend.simple_ecommerce_application.controller;

import com.backend.simple_ecommerce_application.model.Product;
import com.backend.simple_ecommerce_application.service.ProductService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product p = service.getProductById(id);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
        Product p1= service.addProduct(product,imageFile);
        if(p1!=null){
            return new ResponseEntity<>("Added Product Successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("ERROR Adding product",HttpStatus.BAD_REQUEST);
        }
    }
//Fetch Image
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id){
        Product p=service.getProductById(id);
        if(p!=null){
           byte[] image= service.getImageById(id);
           return new ResponseEntity<>(image,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
        Product p1= service.updateProduct(id,product,imageFile);
        if(p1!=null){
            return new ResponseEntity<>("Updated Product Successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("ERROR Adding product",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product p1= service.getProductById(id);
        if(p1==null){
            return new ResponseEntity<>("Product Id doesn't exists",HttpStatus.BAD_REQUEST);
        }else{
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted Product",HttpStatus.OK);
        }
    }

}