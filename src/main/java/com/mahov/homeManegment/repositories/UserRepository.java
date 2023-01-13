package com.mahov.homeManegment.repositories;

import com.mahov.homeManegment.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String ownerName);

    Optional<User> findByLogin(String username);

    boolean existsByLogin(String login);
}
