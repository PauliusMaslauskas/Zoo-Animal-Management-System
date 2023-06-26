package com.app.zooanimalmanagementsystem.interfaces;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.DTO.ZooDTO;

import java.util.Collection;

public interface ZooService {

    void transferAnimals(int zooId, Collection<AnimalDTO> animalDtos);
}
