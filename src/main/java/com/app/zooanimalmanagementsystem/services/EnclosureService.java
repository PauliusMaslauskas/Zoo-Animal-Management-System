package com.app.zooanimalmanagementsystem.services;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EnclosureService implements com.app.zooanimalmanagementsystem.interfaces.EnclosureService {

    private final EnclosureRepository enclosureRepository;

    public List<Enclosure> getAllEnclosures() {
        return enclosureRepository.findAll();
    }

    public Optional<Enclosure> findFittingEnclosure(Collection<Enclosure> enclosures, AnimalDTO animal) {
        Optional<Enclosure> enclosure = enclosures.stream()
                .filter(enc -> filterEnclosureSize(enc, animal))
                .filter(enc -> filterEnclosureFood(enc, animal))
                .filter(this::filterEnclosureAnimalSpecies)
                .findFirst();

        return enclosure ;
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
