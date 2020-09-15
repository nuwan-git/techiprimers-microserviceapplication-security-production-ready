/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "role_feature_permission")
@Data
public class RoleFeaturePermission  extends  SharedModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_FEATURE_PERMISSION_G1")
    @SequenceGenerator(name = "ROLE_G1", sequenceName = "role_seq")
    @Column(name = "role_id")
    private Integer roleFeaturePermissionId;

    @Basic
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Basic
    @Column(name = "feature_permission_id", nullable = false)
    private Integer featurePermissionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_permission_id", insertable = false, updatable = false)
    private FeaturePermission featurePermission;

    @Transient
    List<FeaturePermission> featurePermissions;

}
