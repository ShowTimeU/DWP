package com.dontwaste.model.entity;


import com.dontwaste.model.base.BaseId;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "INSTITUTION")
public class Institution extends BaseId {
    @Column(name = "INSTITUTION_NAME", length = 20, nullable = false)
    private String institutionName;
    @Column(name = "INSTITUTION_LOGO", length = 2600)
    private String institutionLogo;
    @Column(name = "INSTITUTION_SITE", length = 30)
    private String institutionWebSite;
    @Column(name = "INSTITUTION_DESCRIPTION", length = 500)
    private String institutionDescription;

}
