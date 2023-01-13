package com.mahov.homeManegment.repositories;

import com.mahov.homeManegment.domain.models.House;
import com.mahov.homeManegment.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeRepository extends JpaRepository<House,Long> {
        Optional<House> findByOwnerId(Long id);

        Optional<House> findAllByOwnerId(Long id);
}
