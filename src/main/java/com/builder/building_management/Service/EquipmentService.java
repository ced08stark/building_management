package com.builder.building_management.Service;

import com.builder.building_management.Model.Building;
import com.builder.building_management.Model.Equipment;
import com.builder.building_management.Repository.BuildingRepository;
import com.builder.building_management.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    private final BuildingRepository buildingRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, BuildingRepository buildingRepository) {
        this.equipmentRepository = equipmentRepository;
        this.buildingRepository = buildingRepository;
    }


    public List<Equipment> getEquipmentsByBuildingId(Long buildingId) {
        return equipmentRepository.findByBuildingId(buildingId);
    }

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    public Equipment saveEquipment(Equipment equipment, Long buildingId) {
        // Vérifiez si le bâtiment existe
        System.out.println(equipment);
        System.out.println(buildingId);
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found with ID: " + buildingId));

        // Associez le bâtiment à l'équipement
        equipment.setBuilding(building);

        // Sauvegardez l'équipement
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Equipment equipment = getEquipmentById(id);
        if (equipment != null) {
            equipment.setName(updatedEquipment.getName());
            equipment.setStatus(updatedEquipment.getStatus());
            return equipmentRepository.save(equipment);
        }
        return null;
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}

