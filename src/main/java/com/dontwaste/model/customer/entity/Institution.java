package com.dontwaste.model.customer.entity;


import com.dontwaste.model.customer.base.BaseId;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "INSTITUTION")
public class Institution extends BaseId {
    @Column(name = "INSTITUTION_NAME", length = 80, nullable = false)
    private String institutionName;
    @Column(name = "INSTITUTION_LOGO", length = 2600, nullable = false)
    private String institutionLogo;
    @Column(name = "INSTITUTION_CITY", length = 20, nullable = false)
    private String institutionCity;
    @Column(name = "INSTITUTION_ADDRESS", length = 20, nullable = false)
    private String institutionAddress;
    @Column(name = "INSTITUTION_PHONE", length = 20, nullable = false)
    private String institutionPhone;
    @Column(name = "INSTITUTION_SITE", length = 20, nullable = false)
    private String institutionWebSite;
    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User user;
}
