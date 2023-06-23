package com.app.zooanimalmanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class EnclosureDTO {

    private String name;

    private int size;

    private String location;

    private List<String> objects;
}
