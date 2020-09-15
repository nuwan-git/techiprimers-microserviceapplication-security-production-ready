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
public class Permission extends SharedModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_G1")
    @SequenceGenerator(name = "PERMISSION_G1", sequenceName = "permission_seq")
    @Column(name = "permission_id")
    private  Integer permissionId;

    @Basic
    @Column(name = "permission_name")
    private String permissionName;

}
