package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import com.app.zooanimalmanagementsystem.services.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ZooController {

    private ZooService zooService;
    private AnimalRepository animalRepository;

    @PostMapping("/transfer/{id}")
    public void transferAnimals(@PathVariable("id") int id, @RequestBody ZooDTO zooDTO) {
        List<Enclosure> enclosures = zooService.getAll(id);
        List<Animal> animals = new ArrayList<>();

        for (AnimalDTO animal :
                zooDTO.getAnimals()) {

            Optional<Enclosure> enclosure = enclosures.stream()
                    .filter(enc -> filterEnclosureSize(enc, animal))
                    .filter(enc -> filterEnclosureFood(enc, animal))
                    .filter(this::filterEnclosureAnimalSpecies)
                    .findFirst();

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

    private boolean filterEnclosureSize(Enclosure enclosure, AnimalDTO animal) {
        return enclosure.getEnclosureSize() - enclosure.getAnimals().stream().mapToInt(Animal::getAmount).sum() >= animal.getAmount();
    }

    private boolean filterEnclosureFood(Enclosure enclosure, AnimalDTO animal) {
        return enclosure.getAnimals().size() == 0 || enclosure.getAnimals().get(0).getFood() == Diet.valueOf(animal.getFood().toUpperCase());
    }

    private boolean filterEnclosureAnimalSpecies(Enclosure enclosure) {
        if (enclosure.getAnimals().size() == 0) {
            return true;
        }

        Animal firstAnimal = enclosure.getAnimals().get(0);

        if (firstAnimal.getFood() == Diet.HERBIVORE) {
            return true;
        }

        if (firstAnimal.getFood() == Diet.CARNIVORE) {
            return enclosure.getAnimals().stream().collect(Collectors.groupingBy(Animal::getSpecies)).size() < 2;
        }

        return false;
    }

}
