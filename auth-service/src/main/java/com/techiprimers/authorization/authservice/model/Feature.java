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
@Data
public class Feature extends SharedModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEATURE_G1")
    @SequenceGenerator(name = "FEATURE_G1", sequenceName = "feature_seq")
    @Column(name = "feature_id")
    private Integer featureId;

    @Basic
    @Column(name = "feature_name")
    private String featureName;

    @Basic
    @Column(name = "feature_url")
    private String featureUrl;

    @Basic
    @Column(name = "feature_description")
    private String description;

    @Basic
    @Column(name = "is_assigned")
    private Boolean isAssigned;

    @Transient
    private List<Permission> permissions;

}
