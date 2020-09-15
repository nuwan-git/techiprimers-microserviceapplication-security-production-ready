/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.serviceImpl;

import com.techiprimers.authorization.authservice.model.Feature;
import com.techiprimers.authorization.authservice.model.FeaturePermission;
import com.techiprimers.authorization.authservice.service.FeaturePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FeaturePermissionServiceImpl  implements FeaturePermissionService {


    @Override
    public List<FeaturePermission> findFeaturePermissionByFeatureId(Feature feature) {
        return null;
    }

    @Override
    public List<FeaturePermission> findFeaturePermissionsListBy(Integer featureId) {
        return null;
    }

    @Override
    public Set<String> getAuthorities(Integer userId) {
        return null;
    }
}
