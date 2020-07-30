package com.dontwaste.repository;

import com.dontwaste.model.entity.Cart;
import com.dontwaste.model.entity.product.Product;
import com.dontwaste.model.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c from CART c where c.product_id = :productId and c.user_id = :userId")
    Cart getByProductIdAndUserId(@Param("productId") Long productId, @Param("userId") Long userId);

    Cart findByProductAndUser(Product product, User user);

    List<Cart> findAllByUser(User user);
}
