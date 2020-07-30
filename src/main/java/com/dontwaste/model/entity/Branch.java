package com.dontwaste.model.entity;

import com.dontwaste.model.base.BaseId;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "BRANCH")
public class Branch extends BaseId {

    @Column(name = "BRANCH_CITY", length = 20, nullable = false)
    private String branchCity;
    @Column(name = "BRANCH_ADDRESS", length = 30, nullable = false)
    private String branchAddress;
    @Column(name = "BRANCH_PHONE", length = 20, nullable = false)
    private String branchPhone;
    @Column(name = "BRANCH_EMAIL", length = 30)
    private String branchEmail;
    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
    @OneToOne
    @JoinColumn(name = "INSTITUTION_ID", referencedColumnName = "ID")
    private Institution institution;

}
