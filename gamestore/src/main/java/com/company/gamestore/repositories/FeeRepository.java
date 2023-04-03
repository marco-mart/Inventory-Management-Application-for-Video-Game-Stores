package com.company.gamestore.repositories;

import com.company.gamestore.models.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {

    Optional<Fee> findByProduct(String product);

}
