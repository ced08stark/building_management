package com.builder.building_management.Repository;

import com.builder.building_management.Model.Building;
import com.builder.building_management.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
    List<Equipment> findByBuildingId(Long buildingId);
}