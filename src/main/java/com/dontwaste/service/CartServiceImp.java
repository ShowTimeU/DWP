package com.dontwaste.service;

import com.dontwaste.exception.ProductNotFoundException;
import com.dontwaste.exception.UserNotFoundException;
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
            throw  new ProductNotFoundException("Unknown product");
        }
        if(user == null){
            throw  new UserNotFoundException("Unknown user");
        }

        if(product.getQuantity()>0){
            product.setQuantity(product.getQuantity()-1);
            productRepository.save(product);
        }
        if(product.getQuantity()<=1){
            product.setQuantity(0);
            product.setActive(false);
            productRepository.save(product);
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
            throw  new UserNotFoundException("Unknown user");
        }
        return cartRepository.findAllByUser(user).stream()
                 .map(cart -> new ProductsInCartResponce().builder()
                         .id(cart.getId())
                         .userId(cart.getUser().getId())
                         .quantity(cart.getQuantity())
                         .institution(cart.getProduct().getBranch().getInstitution())
                         .product(cart.getProduct())
                         .productTemplate(cart.getProduct().getProductTemplate())
                         .branch(cart.getProduct().getBranch())
                         .build())
        .collect(Collectors.toList());
    }

    @Override
    public void deleteCartItem(Long cartId) {
        Cart cartItemToDelete = cartRepository.findById(cartId).orElse(null);
        if(cartItemToDelete == null){
            throw new ProductNotFoundException("product not exist in cart");
        }
        else{
            Product product = productRepository.findById(cartItemToDelete.getProduct().getId()).orElse(null);
            if(product == null){
                throw new ProductNotFoundException("This product is not exist in cart");
            }
            if(product.getQuantity()>0){
                product.setQuantity(product.getQuantity()+cartItemToDelete.getQuantity());
                productRepository.save(product);
            }
            else{
                product.setQuantity(cartItemToDelete.getQuantity());
                product.setActive(true);
                productRepository.save(product);
            }

        }
        cartRepository.deleteById(cartId);
    }

    @Override
    public void deleteAllCartByUserId(Long userId) {
        cartRepository.deleteAllCartByUserId(userId);
    }

    @Override
    public void deleteProductFromCart(Long productId, Long userId) {
        Cart cartProductToDelete = cartRepository.getByProductIdAndUserId(productId, userId);
        Product product = productRepository.findById(productId).orElse(null);
        if(cartProductToDelete == null){
            throw new ProductNotFoundException("product not exist in cart");
        }
        if(cartProductToDelete.getQuantity()>1){
            cartProductToDelete.setQuantity(cartProductToDelete.getQuantity()-1);
            cartRepository.save(cartProductToDelete);
            if(product.getQuantity()>0){
                product.setQuantity(product.getQuantity()+1);
                productRepository.save(product);
            }
            else{
                product.setQuantity(1);
                product.setActive(true);
                productRepository.save(product);
            }
        }
        else{
            cartRepository.delete(cartProductToDelete);
        }
    }
}
