package com.app.zooanimalmanagementsystem.entities;

import com.app.zooanimalmanagementsystem.enums.EnclosureSize;
import com.app.zooanimalmanagementsystem.enums.Location;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Enclosure {

    @Id
    private int id;
    private String name;

    private EnclosureSize enclosureSize;

    private Location location;

    @OneToMany(mappedBy = "enclosure")
    private List<Animal> animals;

    @OneToMany(mappedBy = "enclosure")
    private List<EnclosureObject> enclosureObjects;
}
