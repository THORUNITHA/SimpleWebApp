package com.backend.simple_ecommerce_application.repository;

import com.backend.simple_ecommerce_application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<Product,Integer> {
}
