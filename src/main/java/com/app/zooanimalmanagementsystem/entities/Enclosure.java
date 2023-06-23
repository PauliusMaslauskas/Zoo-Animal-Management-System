package com.app.zooanimalmanagementsystem.entities;

import com.app.zooanimalmanagementsystem.enums.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Enclosure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int enclosureSize;

    private Location location;

    @OneToMany(mappedBy = "enclosure")
    private List<Animal> animals;

    @OneToMany(mappedBy = "enclosure")
    private List<EnclosureObject> enclosureObjects;

    @ManyToOne
    @JoinColumn(name = "zoo_id", nullable = false)
    private Zoo zoo;
}
