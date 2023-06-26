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
    private static final int MAX_CARNIVORES_PER_ENCLOSURE = 2;
    private final EnclosureRepository enclosureRepository;

    public List<Enclosure> getAllByZooId(int zooId) {
        return enclosureRepository.findAllByZooId(zooId);
    }

    public Optional<Enclosure> findFittingEnclosure(Collection<Enclosure> enclosures, AnimalDTO animal) {
        return enclosures.stream()
                .filter(enc -> filterEnclosureSize(enc, animal.getAmount()))
                .filter(enc -> filterEnclosureDiet(enc, animal.getFood()))
                .filter(this::filterEnclosureAnimalSpecies)
                .findFirst();
    }

    private boolean filterEnclosureSize(Enclosure enclosure, int amount) {
        return enclosure.getEnclosureSize() - enclosure.getAnimals().stream().mapToInt(Animal::getAmount).sum() >= amount;
    }

    private boolean filterEnclosureDiet(Enclosure enclosure, String diet) {
        return enclosure.getAnimals().size() == 0 || enclosure.getAnimals().get(0).getFood() == Diet.valueOf(diet.toUpperCase());
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
            return enclosure.getAnimals().stream().collect(Collectors.groupingBy(Animal::getSpecies)).size() < MAX_CARNIVORES_PER_ENCLOSURE;
        }

        return false;
    }
}
