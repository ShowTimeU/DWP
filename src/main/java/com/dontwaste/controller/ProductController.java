package com.dontwaste.controller;


import com.dontwaste.model.admin.request.ProductCreationRequest;
import com.dontwaste.model.admin.response.ProductCreationResponse;
import com.dontwaste.model.customer.entity.product.Product;
import com.dontwaste.model.customer.web.product.ProductSearchObject;
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

    @PostMapping(value = "/createProduct")
    public ProductCreationResponse createProduct(@RequestBody ProductCreationRequest productCreationRequest){
        return productService.createProduct(productCreationRequest);
    }

//    @PostMapping(value = "/searchProduct")
//    public List<Product> fullSearch(@RequestBody ProductSearchObject searchObject){
//        return productService.fullSearch(searchObject);
//    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    @GetMapping(value = "/getProductsByArea")
//    public List<Product> getProductsByArea(@RequestParam(name = "area") String area){
//        return productService.getProductsByArea(area);
//    }

    @GetMapping(value = "/getProductsByNameLike")
    public List<Product> getProductsByNameLike(@RequestParam(name = "name") String name){
        return productService.getAllProductsByNameLike(name);
    }

    @GetMapping(value = "/getProductsWithPriceBetween")
    public List<Product> getProductsWithPriceBetween(@RequestParam(name = "minPrice") Double min,
                                                     @RequestParam(name = "maxPrice") Double max){
        return productService.getAllProductWithPriceBetween(min, max);
    }

}
