package com.dontwaste.service;

import com.dontwaste.model.admin.request.ProductCreationRequest;
import com.dontwaste.model.admin.response.ProductCreationResponse;
import com.dontwaste.model.customer.entity.product.Product;
import com.dontwaste.model.customer.web.product.ProductSearchObject;

import java.util.List;

public interface ProductService {
    ProductCreationResponse createProduct(ProductCreationRequest productCreationRequest);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
//    List<Product> getProductsByArea(String area);
    List<Product> getAllProductWithPriceBetween(Double min, Double max);
    List<Product> getAllProductsByNameLike(String name);
//    List<Product> fullSearch(ProductSearchObject searchObject);




}
