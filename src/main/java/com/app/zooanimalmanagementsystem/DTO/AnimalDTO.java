package com.app.zooanimalmanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AnimalDTO {

    private String species;

    private String food;

    private int amount;

}
