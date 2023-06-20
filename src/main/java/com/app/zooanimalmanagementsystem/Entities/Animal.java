package com.app.zooanimalmanagementsystem.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Getter
@Setter
@CrossOrigin
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    private int id;

    private String name;
}
