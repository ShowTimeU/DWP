package com.dontwaste.repository;

import com.dontwaste.model.customer.entity.product.Product;
import com.dontwaste.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
//    List<Product> findAllByArea(String area);

    @Query("select p from Product p where p.productName like %:productName%")
    List<Product> getAllProductsByNameLike(@Param("productName") String productName);

    @Query("select p from Product p where p.price between :minPrice and :maxPrice")
    List<Product> getAllProductsWithPriceBetween(@Param("minPrice") Double min,
                                                 @Param("maxPrice") Double max);

}
