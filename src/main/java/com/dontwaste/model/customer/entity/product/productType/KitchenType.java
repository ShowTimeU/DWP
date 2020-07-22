package com.dontwaste.model.customer.entity.product.productType;

import com.dontwaste.model.customer.base.BaseId;
import lombok.*;

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

    private String kitchenName;

}
