package com.dontwaste.repository.productTypes;

import com.dontwaste.model.entity.product.productType.KitchenType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenTypeRepository extends JpaRepository<KitchenType, Long> {
}
