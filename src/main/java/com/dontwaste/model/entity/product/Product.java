package com.dontwaste.model.entity.product;

import com.dontwaste.model.base.BaseDate;
import com.dontwaste.model.entity.ProductTemplate;
import com.dontwaste.model.entity.Branch;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "PRODUCT")
public class Product extends BaseDate {

    @Column(name = "STARTING_PRICE", nullable = false)
    private Double startingPrice;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "ID")
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "ID")
    private ProductTemplate productTemplate;


}
