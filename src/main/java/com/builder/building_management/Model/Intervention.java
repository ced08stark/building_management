package com.builder.building_management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Preventive, Curative
    private String description;
    private LocalDateTime plannedDate;
    private LocalDateTime completedDate;
    private double cost;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public void setPlannedDate(LocalDateTime plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getPlannedDate() {
        return plannedDate;
    }

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TechnicalTeam assignedTeam;

    public Intervention() {
        // Lombok va générer ce constructeur automatiquement avec l'annotation @NoArgsConstructor
    }

    public Intervention(Long id, String type, String description, LocalDateTime plannedDate, LocalDateTime completedDate, double cost, Equipment equipment, TechnicalTeam assignedTeam) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.plannedDate = plannedDate;
        this.completedDate = completedDate;
        this.cost = cost;
        this.equipment = equipment;
        this.assignedTeam = assignedTeam;
    }

    public Intervention(Intervention other) {
        this.id = other.id;
        this.type = other.type;
        this.description = other.description;
        this.plannedDate = other.plannedDate;
        this.completedDate = other.completedDate;
        this.cost = other.cost;
        this.equipment = other.equipment; // Copie de la référence, attention si vous voulez une copie profonde, vous devrez cloner l'objet equipment
        this.assignedTeam = other.assignedTeam; // Copie de la référence, attention si vous voulez une copie profonde
    }
}

