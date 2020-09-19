/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 **/
package com.techiprimers.authorization.authservice.serviceImpl;

import com.techiprimers.authorization.authservice.model.User;
import com.techiprimers.authorization.authservice.model.UserCompany;
import com.techiprimers.authorization.authservice.repository.UserCompanyRepository;
import com.techiprimers.authorization.authservice.repository.UserRepository;
import com.techiprimers.authorization.authservice.service.FeaturePermissionService;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserCompanyRepository userCompanyRepository;
    private final FeaturePermissionService featurePermissionService;

    public CustomUserDetailsService(UserRepository userRepository, UserCompanyRepository userCompanyRepository, FeaturePermissionService featurePermissionService) {
        this.userRepository = userRepository;
        this.userCompanyRepository = userCompanyRepository;
        this.featurePermissionService = featurePermissionService;
    }


    @Override
    public UserDetails loadUserByUsername(String input) {

        Optional<User> user;
        if(input.contains("@")) {
            user = this.userRepository.findByEmail(input);
        } else {
            user = this.userRepository.findByUsername(input);
        }

        if(!user.isPresent()) {
            throw new BadCredentialsException("Bad credentials");
        }

        new AccountStatusUserDetailsChecker().check(user.get());
        user.get().setCompanyId(this.setCompanyProfileSeqForUser(user.get().getUserId()));
        user.get().setAuthorities(this.getAuthoroties(user.get().getUserId()));
        return user.get();
    }

    private Set<GrantedAuthority> getAuthoroties(Integer userId) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<String> urls = featurePermissionService.getAuthorities(userId);
        authorities.add(new SimpleGrantedAuthority("ROLE_TECHIPRIMERS_ADMIN"));
        return  authorities;

    }

    private Integer setCompanyProfileSeqForUser(Integer userId) {
        List<UserCompany> userCompanies = this.userCompanyRepository.findAllByUserId(userId);
        if(userCompanies != null && userCompanies.size() > 0) {
            return userCompanies.get(0).getCompanyId();
        }
        return  null;
    }


}
