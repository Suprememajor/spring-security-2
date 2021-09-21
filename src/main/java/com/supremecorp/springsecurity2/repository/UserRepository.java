package com.supremecorp.springsecurity2.repository;

import com.supremecorp.springsecurity2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by suprememajor on the 9/20/21
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
