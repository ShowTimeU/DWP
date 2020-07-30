package com.dontwaste.model.entity.product.productType;

import com.dontwaste.model.base.BaseId;
import com.dontwaste.model.entity.product.Product;
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
@Table(name = "PRODUCTDISHTYPE")
public class ProductDishType extends BaseId {

    @ManyToOne
    Product product;

    @ManyToOne
    DishType dishType;

}
