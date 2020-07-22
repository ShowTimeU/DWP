package com.dontwaste.model.customer.entity;

import com.dontwaste.model.customer.base.BaseId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USER_ROLE")
public class UserRole extends BaseId {

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;

}
