package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {

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

    private Animal populateFields(Animal animal, AnimalDTO addAnimalDto) {
        animal.setFood(Diet.valueOf(addAnimalDto.getFood().toUpperCase()));
        animal.setSpecies(addAnimalDto.getSpecies());
        animal.setAmount(addAnimalDto.getAmount());
        return animal;
    }
}

