package com.app.zooanimalmanagementsystem.repositories;

import com.app.zooanimalmanagementsystem.entities.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnclosureRepository extends JpaRepository<Enclosure, Integer> {
    List<Enclosure> findAllByZooId(final int zooId);
}
