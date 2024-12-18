package com.builder.building_management.Repository;

import com.builder.building_management.Model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
}

