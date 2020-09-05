package com.dontwaste.service;

import com.dontwaste.model.web.product.ProductCreationRequest;
import com.dontwaste.model.web.product.ProductResponse;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.web.search.ProductSearchRequest;
import com.dontwaste.model.web.search.ProductSearchResponse;

import java.util.List;

public interface ProductService {
    void addProduct(ProductCreationRequest productCreationRequest);
    void deleteProduct(Long id);
    List<ProductResponse> getAllProducts();
    List<ProductSearchResponse> searchProduct(ProductSearchRequest productSearchRequest);
    List<ProductResponse> getAllActiveProducts();





}
