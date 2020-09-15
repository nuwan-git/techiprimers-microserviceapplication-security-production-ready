/**
 * Created by: nuwan_r
 * Created on: 9/12/2020
 **/
package com.techiprimers.authorization.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "company")
@Data
public class Company  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_G1")
    @SequenceGenerator(name = "COMPANY_G1", sequenceName = "company_seq", allocationSize = 1)
    @Column(name = "company_id")
    private Integer companyId;

    @Basic
    @Column(name = "company_name")
    private String companyName;

    @Basic
    @Column(name = "company_description")
    private String comapanyDescription;

    @Basic
    @Column(name = "company_address")
    private String companyAddress;

    @Basic
    @Column(name = "company_email")
    private String comapanyEmail;

    @Basic
    @Column(name = "company_contactno")
    private String comapanyContactNumber;

}
