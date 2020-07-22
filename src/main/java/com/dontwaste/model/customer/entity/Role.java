package com.dontwaste.model.customer.entity;

import com.dontwaste.model.customer.base.BaseId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "ROLE")
public class Role extends BaseId {
    @Column(name = "ROLE_NAME", unique = true, nullable = false)
    private String roleName;

    @Column(unique = true)
    private Boolean isDefault;

}
