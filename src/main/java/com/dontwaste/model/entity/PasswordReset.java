package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "PASSWORD_RESET")
public class PasswordReset extends BaseId {

    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", unique = true)
    private User user;

    @Column(name = "EXPIRY_DATE")
    private LocalDateTime expiryDate;

}
