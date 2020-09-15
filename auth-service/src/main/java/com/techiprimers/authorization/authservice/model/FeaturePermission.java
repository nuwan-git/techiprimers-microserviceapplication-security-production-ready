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
@Table(name = "feature_permission")
public class FeaturePermission extends SharedModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEATURE_PERMISSION_G1")
    @SequenceGenerator(name = "FEATURE_PERMISSION_G1", sequenceName = "feature_permission_seq")
    @Column(name = "feature_permission_id")
    private Integer featurePermissionId;

    @Basic
    @Column(name = "feature_permission_url")
    private String featurePermissionUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private Feature feature;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private Permission permission;


}
