package com.supremecorp.springsecurity2.repository;

import com.supremecorp.springsecurity2.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by suprememajor on the 9/20/21
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
