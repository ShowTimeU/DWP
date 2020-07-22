package com.dontwaste.service;

import com.dontwaste.model.customer.web.cart.ProductToCartRequest;
import com.dontwaste.model.customer.web.cart.ProductsInCartResponce;

import java.util.List;

public interface CartService {

    void addProductToCart(ProductToCartRequest productToCartRequest);
    List<ProductsInCartResponce> getAllProductsInCart(Long userId);
    void deleteProductFromCart(Long productId, Long userId);

}
