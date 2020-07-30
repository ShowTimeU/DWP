package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
import lombok.*;

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
