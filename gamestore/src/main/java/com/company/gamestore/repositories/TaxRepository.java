package com.company.gamestore.repositories;


import com.company.gamestore.models.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository <Tax, Integer> {


    Optional<Tax> findByState(String state);
}
