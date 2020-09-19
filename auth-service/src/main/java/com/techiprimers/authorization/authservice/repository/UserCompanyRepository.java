/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.repository;

import com.techiprimers.authorization.authservice.model.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Integer> {

    List<UserCompany> findAllByUserId(Integer userId);
}
