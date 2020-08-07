package com.dontwaste.repository.productTypes;

import com.dontwaste.model.entity.product.productType.DishType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishTypeRepository extends JpaRepository<DishType, Long> {
}
