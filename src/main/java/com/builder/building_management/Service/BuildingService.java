package com.builder.building_management.Service;

import com.builder.building_management.Model.Building;
import com.builder.building_management.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(Long id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building updateBuilding(Long id, Building updatedBuilding) {
        Building building = getBuildingById(id);
        if (building != null) {
            building.setName(updatedBuilding.getName());
            building.setLocation(updatedBuilding.getLocation());
            return buildingRepository.save(building);
        }
        return null;
    }

    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }
}

