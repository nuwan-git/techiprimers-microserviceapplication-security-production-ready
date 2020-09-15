/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Role extends SharedModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_G1")
    @SequenceGenerator(name = "ROLE_G1", sequenceName = "role_seq")
    @Column(name = "role_id")
    private Integer roleId;

    @Basic
    @Column(name = "role_name")
    private String roleName;

    @Basic
    @Column(name = "role_description")
    private String roleDescription;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;
}
