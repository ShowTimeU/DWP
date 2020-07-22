package com.dontwaste.model.customer.entity;

import com.dontwaste.model.customer.base.BaseId;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "SESSION")
public class Session extends BaseId {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @Column(unique = true)
    private String token;

}
