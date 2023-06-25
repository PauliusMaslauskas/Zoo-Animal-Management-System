package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ZooService {

    private EnclosureRepository enclosureRepository;

    public List<Enclosure> getAll(int id) {
        return enclosureRepository.findAllByZooId(id);
    }
}

