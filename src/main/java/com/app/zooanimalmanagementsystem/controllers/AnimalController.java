package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.AddAnimalDTO;
import com.app.zooanimalmanagementsystem.entities.Animal;
import com.app.zooanimalmanagementsystem.interfaces.ZooService;
import com.app.zooanimalmanagementsystem.services.AnimalService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public ResponseEntity<Void> addAnimal(@RequestBody AddAnimalDTO addAnimalDto) {
        try {
            zooService.transferAnimals(addAnimalDto.getZooId(), Arrays.asList(addAnimalDto.getAnimal()));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        try {
            List<Animal> animals = animalService.getAllAnimals();
            return ResponseEntity.ok().body(animals);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") int id){
        try {
            Animal animal = animalService.findAnimalById(id);
            return ResponseEntity.ok().body(animal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping ("/animal/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") int id){
        animalService.deleteAnimal(id);
        try {
            animalService.deleteAnimal(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
