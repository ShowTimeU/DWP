package com.dontwaste.controller;

import com.dontwaste.model.customer.web.cart.ProductToCartRequest;
import com.dontwaste.model.customer.web.cart.ProductsInCartResponce;
import com.dontwaste.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/addToCart")
    public void addProductToCart(@RequestBody ProductToCartRequest productToCartRequest){
        cartService.addProductToCart(productToCartRequest);
    }

    @GetMapping(value = "/getAllCart")
    public List<ProductsInCartResponce> getAllProductsInCart(@RequestParam(name = "userId") Long userId){
        return cartService.getAllProductsInCart(userId);
    }

    @DeleteMapping(value = "/deleteFromCart")
    public void deleteProductFromCart (@RequestParam(name = "productId") Long productId,
                                       @RequestParam(name = "userId") Long userId){
        cartService.deleteProductFromCart(productId, userId);
    }


}
