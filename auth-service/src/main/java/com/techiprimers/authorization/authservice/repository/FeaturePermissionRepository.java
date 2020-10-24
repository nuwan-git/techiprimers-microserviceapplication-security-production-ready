/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 */
package com.techiprimers.authorization.authservice.repository;

import com.techiprimers.authorization.authservice.model.FeaturePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FeaturePermissionRepository extends JpaRepository <FeaturePermission,Integer>  {

    @Query(value = "select result1.* from (select fp.feature_permission_url from permod.role_feature_permission rfp\n" +
            "INNER JOIN permod.feature_permission fp ON\n" +
            "rfp.feature_permission_id = fp.feature_permission_id\n" +
            "INNER JOIN permod.feature f\n" +
            "ON f.feature_id = fp.feature_id\n" +
            "where rfp.role_id = :roleId) AS result1", nativeQuery = true)
    Set<String> findAllthePermissionIdsForRole(@Param("roleId") Integer roleId);

}
