package com.app.zooanimalmanagementsystem.entities;

import com.app.zooanimalmanagementsystem.enums.Diet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String species;

    private Diet food;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "enclosure_id", nullable = false)
    private Enclosure enclosure;
}
