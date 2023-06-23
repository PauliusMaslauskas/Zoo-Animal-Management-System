package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {

    @Autowired
    private final AnimalRepository animalRepository;

    public Animal saveAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal = populateFields(animal, animalDTO);
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal findAnimalById(int id) {
        return animalRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Item Not Found"
        ));
    }

    public Animal updateAnimal(AnimalDTO animalDTO, int id) {
        Animal animal = findAnimalById(id);
        animal = populateFields(animal, animalDTO);
        return animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
    private Animal populateFields(Animal animal, AnimalDTO animalDTO) {
        animal.setFood(Diet.valueOf(animalDTO.getFood().toUpperCase()));
        animal.setSpecies(animalDTO.getSpecies());
        animal.setAmount(animalDTO.getAmount());
        return animal;
    }
}

