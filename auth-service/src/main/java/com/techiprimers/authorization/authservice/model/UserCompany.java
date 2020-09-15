/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class UserCompany extends SharedModel implements Serializable {

    private Integer userCompanyId;
    private Integer userId;
    private Integer companyId;
    private Integer status;

    private Company companyProfile;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_COMPANY_G1")
    @SequenceGenerator(name = "USER_COMPANY_G1", sequenceName = "user_company_seq", allocationSize = 1)
    @Column(name = "user_company_id")
    public Integer getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(Integer userCompanyId) {
        this.userCompanyId = userCompanyId;
    }


    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    public Company getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(Company companyProfile) {
        this.companyProfile = companyProfile;
    }

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

