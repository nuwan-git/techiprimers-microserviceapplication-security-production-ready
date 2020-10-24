/**
 * Created by: nuwan_r
 * Created on: 9/13/2020
 */
package com.techiprimers.authorization.authservice.repository;

import com.techiprimers.authorization.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUserId(Integer userId);
}
