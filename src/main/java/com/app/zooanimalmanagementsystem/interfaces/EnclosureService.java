package com.app.zooanimalmanagementsystem.interfaces;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Enclosure;

import java.util.Collection;
import java.util.Optional;

public interface EnclosureService {
    Optional<Enclosure> findFittingEnclosure(Collection<Enclosure> enclosures, AnimalDTO animal);
}