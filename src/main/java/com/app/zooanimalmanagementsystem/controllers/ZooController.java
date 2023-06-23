package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.AnimalRepository;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import com.app.zooanimalmanagementsystem.services.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ZooController {
    private ZooService zooService;
    private EnclosureRepository enclosureRepository;
    private AnimalRepository animalRepository;

    @PostMapping("/transfer/{id}")
    public void transferAnimals(@PathVariable("id") int id, @RequestBody ZooDTO zooDTO) {
        List<Enclosure> enclosures = zooService.getAll(id);
        List<AnimalDTO> vegies = zooDTO.getAnimals().stream()
                .filter(animal -> animal.getFood().equals(Diet.HERBIVORE.toString()))
                .toList();

        int total = vegies.stream().mapToInt(AnimalDTO::getAmount).sum();

        for (AnimalDTO animal:
                zooDTO.getAnimals()) {

            Optional<Enclosure> enclosure = enclosures.stream()
                    .filter(enc -> enc.getEnclosureSize() - enc.getAnimals().stream().mapToInt(Animal::getAmount).sum() >= animal.getAmount())
                    .filter(enc -> enc.getAnimals().size() == 0 || enc.getAnimals().get(0).getFood() == (Diet.valueOf(animal.getFood().toUpperCase())))
                    .filter(enc -> enc.getAnimals().size() == 0 ||
                                    enc.getAnimals().get(0).getFood() == Diet.HERBIVORE ||
                            enc.getAnimals().get(0).getFood() == Diet.CARNIVORE && enc.getAnimals().stream().collect(Collectors.groupingBy(Animal::getSpecies)).size() < 2 )
                    .findFirst();



            Animal newAnimal = new Animal();
            newAnimal.setAmount(animal.getAmount());
            newAnimal.setSpecies(animal.getSpecies());
            newAnimal.setFood(Diet.valueOf(animal.getFood().toUpperCase()));
            newAnimal.setEnclosure(enclosure.get());

            enclosure.get().getAnimals().add(newAnimal);

            animalRepository.save(newAnimal);
        }
    }
}
