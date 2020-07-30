package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
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

    @OneToOne
    @JoinColumn(name = "INSTITUTION_ID", referencedColumnName = "ID")
    private Institution institution;


//    @Column(name = "KOSHER")
//    private boolean kosher;
//
//    @Column(name = "VEGETERIAN")
//    private boolean vegeterian;
//
//    @Column(name = "VEGAN")
//    private boolean vegan;

}
