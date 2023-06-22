package com.app.zooanimalmanagementsystem.entities;

import com.app.zooanimalmanagementsystem.enums.EnclosureSize;
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
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "zoo")
    private List<Enclosure> enclosures;
}
