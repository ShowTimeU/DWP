package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
import com.dontwaste.model.entity.product.Product;
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
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

}
