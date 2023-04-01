package com.company.gamestore.repositories;
import com.company.gamestore.models.Tshirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TshirtRepository extends JpaRepository<Tshirt, Integer> {
    //List<Tshirt> findAllBySize(int size);
    List<Tshirt> findAllByColor(String color);

    List<Tshirt> findAllBySize(String size);

}