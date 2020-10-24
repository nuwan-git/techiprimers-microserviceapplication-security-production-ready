/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.serviceImpl;

import com.techiprimers.authorization.authservice.model.Feature;
import com.techiprimers.authorization.authservice.model.FeaturePermission;
import com.techiprimers.authorization.authservice.model.User;
import com.techiprimers.authorization.authservice.repository.FeaturePermissionRepository;
import com.techiprimers.authorization.authservice.repository.UserRepository;
import com.techiprimers.authorization.authservice.service.FeaturePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FeaturePermissionServiceImpl  implements FeaturePermissionService {


    private final UserRepository userRepository;
    private final FeaturePermissionRepository featurePermissionRepository;

    @Autowired
    public FeaturePermissionServiceImpl(UserRepository userRepository,
                                        FeaturePermissionRepository featurePermissionRepository) {
        this.userRepository = userRepository;
        this.featurePermissionRepository = featurePermissionRepository;
    }

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

        Optional<User> userObj = this.userRepository.findByUserId(userId);
        Set<String> permissions = new HashSet<>();

        if(userObj.isPresent()) {
            permissions = this.featurePermissionRepository.findAllthePermissionIdsForRole(userObj.get().getRole().getRoleId());
        }

        return permissions;

    }
}
