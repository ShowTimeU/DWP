package com.dontwaste.model.customer.entity;


import com.dontwaste.model.customer.base.BaseId;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "INSTITUTION")
public class Institution extends BaseId {
    @Column(name = "INSTITUTION_NAME", length = 80, nullable = false)
    private String institutionName;
    @Column(name = "INSTITUTION_PASSWORD", length = 50, nullable = false)
    private String institutionPassword;
    @Column(name = "INSTITUTION_LOGO", length = 2600, nullable = false)
    private String institutionLogo;
    @Column(name = "INSTITUTION_EMAIL", length = 50, nullable = false)
    private String institutionEmail;
    @Column(name = "INSTITUTION_AREA", length = 20, nullable = false)
    private String institutionCity;
    @Column(name = "INSTITUTION_ADDRESS", length = 20, nullable = false)
    private String institutionAddress;
    @Column(name = "INSTITUTION_PHONE", length = 20, nullable = false)
    private String institutionPhone;
    @Column(name = "INSTITUTION_SITE", length = 20, nullable = false)
    private String institutionWebSite;
    @Column(name = "INSTITUTION_COMMENT", length = 500)
    private String institutionComment;
}
