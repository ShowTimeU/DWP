package com.dontwaste.model.entity.product.productType;

import com.dontwaste.model.base.BaseId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "KITCHENTYPE")
public class KitchenType extends BaseId {
    @Column(name = "KITCHENNAME")
    private String kitchenName;

}
