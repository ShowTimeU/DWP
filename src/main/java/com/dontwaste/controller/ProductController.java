package com.dontwaste.controller;


import com.dontwaste.model.web.product.ProductCreationRequest;
import com.dontwaste.model.web.product.ProductResponse;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.web.search.ProductSearchRequest;
import com.dontwaste.model.web.search.ProductSearchResponse;
import com.dontwaste.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody ProductCreationRequest productCreationRequest){
        productService.addProduct(productCreationRequest);
    }

    @PostMapping(value = "/searchProduct")
    public List<ProductSearchResponse> fullSearch(@RequestBody ProductSearchRequest searchRequest){
        return productService.searchProduct(searchRequest);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping(value = "/getAllProducts")
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
