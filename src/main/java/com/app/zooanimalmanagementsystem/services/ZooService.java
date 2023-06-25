package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.interfaces.EnclosureService;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ZooService implements com.app.zooanimalmanagementsystem.interfaces.ZooService {

    private EnclosureRepository enclosureRepository;
    private AnimalRepository animalRepository;
    private EnclosureService enclosureService;


    public List<Enclosure> getAll(int id) {
        return enclosureRepository.findAllByZooId(id);
    }

    public void transferAnimals(int zooId, ZooDTO zooDTO) {
        List<Enclosure> enclosures = getAll(zooId);
        List<Animal> animals = new ArrayList<>();

        for (AnimalDTO animal :
                zooDTO.getAnimals()) {

            Optional<Enclosure> enclosure = enclosureService.findFittingEnclosure(enclosures, animal);

            if (enclosure.isEmpty()) {
                throw new NullPointerException("There is no empty enclosure.");
            }

            Animal newAnimal = new Animal();
            newAnimal.setAmount(animal.getAmount());
            newAnimal.setSpecies(animal.getSpecies());
            newAnimal.setFood(Diet.valueOf(animal.getFood().toUpperCase()));
            newAnimal.setEnclosure(enclosure.get());

            enclosure.get().getAnimals().add(newAnimal);
            animals.add(newAnimal);
        }

        animalRepository.saveAll(animals);
    }
}





