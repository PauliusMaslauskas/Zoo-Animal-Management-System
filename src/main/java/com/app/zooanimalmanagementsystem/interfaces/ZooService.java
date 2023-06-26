package com.app.zooanimalmanagementsystem.interfaces;

import com.app.zooanimalmanagementsystem.DTO.ZooDTO;

public interface ZooService {

    void transferAnimals(int zooId, ZooDTO zooDTO);
}
