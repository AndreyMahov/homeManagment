package com.mahov.homeManegment.repositories;

import com.mahov.homeManegment.domain.enums.ERole;
import com.mahov.homeManegment.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole roleUser);
}
