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
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status; // OK, Broken, Needs Maintenance

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBuilding(Building b){
        this.building = b;
    }

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Intervention> interventions;

    public Equipment() {
        // Lombok va générer ce constructeur automatiquement avec l'annotation @NoArgsConstructor
    }


    public Equipment(Long id, String name, String status, Building building, List<Intervention> interventions) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.building = building;
        this.interventions = interventions;
    }

    public Equipment(Equipment other) {
        this.id = other.id;
        this.name = other.name;
        this.status = other.status;
        this.building = other.building; // Copie de la référence (attention si vous voulez une copie profonde, il faut cloner aussi l'objet building)
        this.interventions = other.interventions;

    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", building=" + building +
                ", interventions=" + interventions +
                '}';
    }
}
