package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.interfaces.ZooService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ZooController {

    private final ZooService zooService;
    Logger logger = LoggerFactory.getLogger(ZooController.class);

    @PostMapping("/transfer/{id}")
    public ResponseEntity<String> transferAnimals(@PathVariable("id") int id, @RequestBody ZooDTO zooDTO) {

        try {
            zooService.transferAnimals(id, zooDTO.getAnimals());
            return ResponseEntity.ok(null);
        } catch (NullPointerException ex) {
            logger.error(ex.getMessage(), ex);
            return ResponseEntity.badRequest().body("Could not transfer the animals.");
        }
    }
}
