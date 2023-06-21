package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.AnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.services.AnimalService;
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
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private final AnimalService animalService;

    @PostMapping("/add")
    public Animal addAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.saveAnimal(animalDTO);
    }

    @GetMapping("/getAll")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") int id){
        return animalService.findAnimalById(id);
    }

    @PutMapping("/update/{id}")
    public Animal updateAnimal(@RequestBody AnimalDTO animalDTO,@PathVariable("id") int id){
        return animalService.updateAnimal(animalDTO, id);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteAnimal(@PathVariable("id") int id){
        animalService.deleteAnimal(id);
    }
}
