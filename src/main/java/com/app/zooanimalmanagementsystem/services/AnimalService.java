package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService implements com.app.zooanimalmanagementsystem.interfaces.AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal findAnimalById(int id) {
        return animalRepository.findById(id).orElseThrow(() -> new NullPointerException("Animal Not Found"));
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}

