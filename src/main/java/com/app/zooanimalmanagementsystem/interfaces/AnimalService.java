package com.app.zooanimalmanagementsystem.interfaces;

import com.app.zooanimalmanagementsystem.entities.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Animal findAnimalById(int id);
    void deleteAnimal(int id);

}
