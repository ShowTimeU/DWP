package com.dontwaste.model.customer.entity.product.productType;

import com.dontwaste.model.customer.base.BaseId;
import com.dontwaste.model.customer.entity.product.Product;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCTKITCHENTYPE")
public class ProductKitchenType extends BaseId {

    @ManyToOne
    Product product;

    @ManyToOne
    KitchenType kitchenType;
}
