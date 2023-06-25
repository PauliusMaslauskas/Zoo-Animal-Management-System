package com.app.zooanimalmanagementsystem.controllers;

import com.app.zooanimalmanagementsystem.DTO.ZooDTO;
import com.app.zooanimalmanagementsystem.interfaces.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ZooController {

    private ZooService zooService;
    @PostMapping("/transfer/{id}")
    public void transferAnimals(@PathVariable("id") int id, @RequestBody ZooDTO zooDTO) {
      zooService.transferAnimals(id, zooDTO);
    }
}
