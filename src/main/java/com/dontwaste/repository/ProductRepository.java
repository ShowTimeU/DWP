package com.dontwaste.repository;

import com.dontwaste.model.entity.product.Product;
import com.dontwaste.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    List<Product> findAllByActiveTrue();

}
