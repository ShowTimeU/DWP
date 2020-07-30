package com.dontwaste.model.entity.product.productType;

import com.dontwaste.model.base.BaseId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "DISHTYPE")
public class DishType extends BaseId {

    private String dishType;

}
