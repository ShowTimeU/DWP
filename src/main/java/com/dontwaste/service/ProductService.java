package com.dontwaste.service;

import com.dontwaste.model.web.product.ProductCreationRequest;
import com.dontwaste.model.web.product.ProductResponse;
import com.dontwaste.model.entity.product.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductCreationRequest productCreationRequest);
    void deleteProduct(Long id);
    List<ProductResponse> getAllProducts();

//    List<Product> getAllProductWithPriceBetween(Double min, Double max);
//    List<Product> getAllProductsByNameLike(String name);





}
