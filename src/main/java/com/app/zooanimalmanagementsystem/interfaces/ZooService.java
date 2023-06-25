package com.app.zooanimalmanagementsystem.interfaces;

import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.entities.Enclosure;

import java.util.List;

public interface ZooService {

    void transferAnimals(int zooId, ZooDTO zooDTO);
    List<Enclosure> getAll(int id);
}
