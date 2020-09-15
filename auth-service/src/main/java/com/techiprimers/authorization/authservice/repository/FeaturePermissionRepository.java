/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 */
package com.techiprimers.authorization.authservice.repository;

import com.techiprimers.authorization.authservice.model.FeaturePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeaturePermissionRepository extends JpaRepository <FeaturePermission,Integer>  {

}
