/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 */
package com.techiprimers.authorization.authservice.service;

import com.techiprimers.authorization.authservice.model.Feature;
import com.techiprimers.authorization.authservice.model.FeaturePermission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface FeaturePermissionService {

    List<FeaturePermission> findFeaturePermissionByFeatureId(Feature feature);

    List<FeaturePermission> findFeaturePermissionsListBy(Integer featureId);

    Set<String> getAuthorities(Integer userId);
}
