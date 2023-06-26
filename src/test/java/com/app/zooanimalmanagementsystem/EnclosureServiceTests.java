package com.app.zooanimalmanagementsystem;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.entities.Enclosure;
import com.app.zooanimalmanagementsystem.enums.Diet;
import com.app.zooanimalmanagementsystem.repositories.EnclosureRepository;
import com.app.zooanimalmanagementsystem.services.EnclosureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EnclosureServiceTests {
    @Mock
    private EnclosureRepository enclosureRepository;
    private EnclosureService enclosureService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        enclosureService = new EnclosureService(enclosureRepository);
    }

    @Test
    public void givenAllEmptyEnclosures_whenFindFittingEnclosure_thenReturnsFirstEnclosure() {
        // Arrange
        Enclosure enclosure1 = createEnclosure(1, 10);
        Enclosure enclosure2 = createEnclosure(2, 5);
        Enclosure enclosure3 = createEnclosure(3, 15);
        List<Enclosure> enclosures = Arrays.asList(enclosure1, enclosure2, enclosure3);

        AnimalDTO animal = new AnimalDTO("Lion", "Carnivore", 2);

        // Act
        Optional<Enclosure> result = enclosureService.findFittingEnclosure(enclosures, animal);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(enclosure1, result.get());
    }
    @Test
    public void givenNoEnclosures_whenFindFittingEnclosure_thenReturnsNoEnclosure() {
        // Arrange
        ArrayList<Enclosure> enclosures = new ArrayList<>();
        AnimalDTO animal = new AnimalDTO("Lion", "Carnivore", 2);

        // Act
        Optional<Enclosure> result = enclosureService.findFittingEnclosure(enclosures, animal);

        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void givenTwoCarnivores_whenFindFittingEnclosure_thenReturnsEnclosureWithoutCarnivores() {
        // Arrange
        Enclosure enclosure1 = createEnclosure(1, 10);
        Enclosure enclosure2 = createEnclosure(2, 5);
        List<Enclosure> enclosures = Arrays.asList(enclosure1, enclosure2);

        Animal animal1 = createAnimal("Wolf", Diet.CARNIVORE, 2);
        Animal animal2 = createAnimal("Lion", Diet.CARNIVORE, 2);
        enclosure1.setAnimals(Arrays.asList(animal1, animal2));

        AnimalDTO animalDTO = new AnimalDTO("Tiger", Diet.CARNIVORE.toString(), 2);

        // Act
        Optional<Enclosure> result = enclosureService.findFittingEnclosure(enclosures, animalDTO);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(enclosure2, result.get());
    }

    @Test
    public void givenHerbivores_whenFindFittingEnclosure_thenReturnsEnclosureWithHerbivores() {
        // Arrange
        Enclosure enclosure1 = createEnclosure(1, 10);
        Enclosure enclosure2 = createEnclosure(2, 5);
        List<Enclosure> enclosures = Arrays.asList(enclosure1, enclosure2);

        Animal animal1 = createAnimal("Gorrila", Diet.HERBIVORE, 2);
        Animal animal2 = createAnimal("Zebra", Diet.HERBIVORE, 2);
        enclosure1.setAnimals(Arrays.asList(animal1, animal2));

        AnimalDTO animalDTO = new AnimalDTO("Elephant", Diet.HERBIVORE.toString(), 2);

        // Act
        Optional<Enclosure> result = enclosureService.findFittingEnclosure(enclosures, animalDTO);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(enclosure1, result.get());
    }

    @Test
    public void givenCarnivore_whenFindFittingEnclosure_thenReturnsEnclosureWithoutHerbivore() {
        // Arrange
        Enclosure enclosure1 = createEnclosure(1, 10);
        Enclosure enclosure2 = createEnclosure(2, 5);
        List<Enclosure> enclosures = Arrays.asList(enclosure1, enclosure2);

        Animal animal1 = createAnimal("Gorrila", Diet.HERBIVORE, 2);
        Animal animal2 = createAnimal("Zebra", Diet.HERBIVORE, 2);
        enclosure1.setAnimals(Arrays.asList(animal1, animal2));

        AnimalDTO animalDTO = new AnimalDTO("Wolf", Diet.CARNIVORE.toString(), 2);

        // Act
        Optional<Enclosure> result = enclosureService.findFittingEnclosure(enclosures, animalDTO);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(enclosure2, result.get());
    }

    private Animal createAnimal(String species, Diet food, int amount) {
        Animal animal = new Animal();
        animal.setSpecies(species);
        animal.setFood(food);
        animal.setAmount(amount);
        return animal;
    }

    private Enclosure createEnclosure(int id, int enclosureSize) {
        Enclosure enclosure = new Enclosure();
        enclosure.setId(id);
        enclosure.setEnclosureSize(enclosureSize);
        enclosure.setAnimals(new ArrayList<>());
        return enclosure;
    }
}