package com.builder.building_management.Repository;

import com.builder.building_management.Model.Building;
import com.builder.building_management.Model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
}