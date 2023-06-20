package com.app.zooanimalmanagementsystem.Repositories;

import com.app.zooanimalmanagementsystem.Entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {


}
