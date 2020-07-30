package com.dontwaste.service;

import com.dontwaste.model.entity.Cart;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.entity.User;
import com.dontwaste.model.web.cart.ProductToCartRequest;
import com.dontwaste.model.web.cart.ProductsInCartResponce;
import com.dontwaste.repository.CartRepository;
import com.dontwaste.repository.ProductRepository;
import com.dontwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImp implements CartService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProductToCart(ProductToCartRequest productToCartRequest) {
        Product product = productRepository.findById(productToCartRequest.getProductId()).get();
        User user = userRepository.findById(productToCartRequest.getUserId()).get();
        if(product == null){
            throw  new RuntimeException("Unknown product");
        }
        if(user == null){
            throw  new RuntimeException("Unknown user");
        }

        Cart cart = cartRepository.findByProductAndUser(product, user);
        if(cart == null){
            Cart newCart = Cart.builder()
                    .product(product)
                    .quantity(1)
                    .user(user)
                    .build();
            cartRepository.save(newCart);
        } else {
            cart.setQuantity(cart.getQuantity()+1);
            cartRepository.save(cart);
        }
    }

    @Override
    public List<ProductsInCartResponce> getAllProductsInCart(Long userId) {
        User user = userRepository.findById(userId).get();
        if(user == null){
            throw  new RuntimeException("Unknown user");
        }
        return cartRepository.findAllByUser(user).stream()
                 .map(x -> new ProductsInCartResponce().builder()
                         .id(x.getId())
                         .userId(x.getUser().getId())
                         .productId(x.getProduct().getId())
                         .price(x.getProduct().getPrice())
                         .quantity(x.getQuantity())
                         .build())
        .collect(Collectors.toList());

    }

    @Override
    public void deleteProductFromCart(Long productId, Long userId) {
        Cart cartProductToDelete = cartRepository.getByProductIdAndUserId(productId, userId);
        if(cartProductToDelete == null){
            throw new RuntimeException("product not exist in cart");
        }
        if(cartProductToDelete.getQuantity()>1){
            cartProductToDelete.setQuantity(cartProductToDelete.getQuantity()-1);
            cartRepository.save(cartProductToDelete);
        }
        else{
            cartRepository.delete(cartProductToDelete);
        }
    }
}
