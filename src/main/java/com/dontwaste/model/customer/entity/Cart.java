package com.dontwaste.model.customer.entity;

import com.dontwaste.model.customer.base.BaseId;
import com.dontwaste.model.customer.entity.product.Product;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "CART")
public class Cart extends BaseId {

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
