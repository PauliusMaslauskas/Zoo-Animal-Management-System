package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.services.AnimalService;
import com.app.zooanimalmanagementsystem.services.ZooService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@AllArgsConstructor
@RestController
@ControllerAdvice
@JsonIgnoreProperties
public class AnimalController {

    @Autowired
    private final AnimalService animalService;
    private final ZooService zooService;

    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.saveAnimal(animalDTO);
    }

    @GetMapping("/animals")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable("id") int id){
        return animalService.findAnimalById(id);
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@RequestBody AnimalDTO animalDTO,@PathVariable("id") int id){
        return animalService.updateAnimal(animalDTO, id);
    }

    @DeleteMapping ("/animal/{id}")
    public void deleteAnimal(@PathVariable("id") int id){
        animalService.deleteAnimal(id);
    }
}
