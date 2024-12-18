package com.builder.building_management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    public Building() {
    }

    public Building(Long id, String location, String name) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Building(Long id, String name, String location, List<Equipment> equipments) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.equipments = equipments;
    }

    public Building(Building other) {
        this.id = other.id; // Vous pouvez choisir d'exclure l'ID si vous voulez une nouvelle entité distincte.
        this.name = other.name;
        this.location = other.location;
        this.equipments = other.equipments; // Attention, ceci copie uniquement la référence à la liste.
    }

    @Override
    public String toString() {
        return "Building{id='"+ id +"', name='" + name + "', location='" + location + "'}";
    }

}

