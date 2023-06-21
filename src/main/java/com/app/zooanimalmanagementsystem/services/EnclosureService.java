package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class EnclosureService {

    private final EnclosureRepository enclosureRepository;


    private Enclosure addEnclosure(Enclosure enclosure){
        return enclosureRepository.save(enclosure);
    }
}
