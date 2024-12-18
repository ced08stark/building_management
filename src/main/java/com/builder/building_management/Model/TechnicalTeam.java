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
public class TechnicalTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String expertise;


    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @OneToMany(mappedBy = "assignedTeam", cascade = CascadeType.ALL)
    private List<Intervention> interventions;

    public TechnicalTeam() {
        // Lombok va générer ce constructeur automatiquement avec l'annotation @NoArgsConstructor
    }

    public TechnicalTeam(Long id, String name, String expertise, List<Intervention> interventions) {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
        this.interventions = interventions;
    }

    public TechnicalTeam(TechnicalTeam other) {
        this.id = other.id;
        this.name = other.name;
        this.expertise = other.expertise;
        this.interventions = other.interventions; // Copie de la référence, attention si vous voulez une copie profonde, vous devrez cloner les objets de la liste
    }
}

