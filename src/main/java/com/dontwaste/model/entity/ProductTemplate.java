package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
import com.dontwaste.model.entity.product.productType.DishType;
import com.dontwaste.model.entity.product.productType.KitchenType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCT_TEMPLATE")
public class ProductTemplate extends BaseId {

    @Column(name = "PRODUCT_NAME", length = 30)
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    @Length(max = 500)
    private String productDescription;

    @Column(name = "PRODUCT_IMAGE", nullable = false)
    @Length(max = 2600)
    private String productImage;

    @Column(name = "KOSHER")
    private boolean kosher;

    @Column(name = "VEGETARIAN")
    private boolean vegetarian;

    @Column(name = "VEGAN")
    private boolean vegan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSTITUTION_ID", referencedColumnName = "ID")
    private Institution institution;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KITCHENTYPE_ID", referencedColumnName = "ID")
    private KitchenType kitchenType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISHTYPE_ID", referencedColumnName = "ID")
    private DishType dishType;




}
