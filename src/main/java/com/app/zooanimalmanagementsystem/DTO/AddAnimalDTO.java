package com.app.zooanimalmanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddAnimalDTO {

    private AnimalDTO animal;

    private int zooId;
}
