package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EnclosureService {

    private final EnclosureRepository enclosureRepository;

    public List<Enclosure> getAllEnclosures() {
        return enclosureRepository.findAll();
    }
}
