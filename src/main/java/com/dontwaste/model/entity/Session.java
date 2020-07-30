package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
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
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    User user;

    @Column(unique = true)
    private String token;

}
