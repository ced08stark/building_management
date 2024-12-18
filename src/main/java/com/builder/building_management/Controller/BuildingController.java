package com.builder.building_management.Controller;

import com.builder.building_management.Model.Building;
import com.builder.building_management.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<?> getAllBuildings() {
        System.out.println(buildingService.getAllBuildings());
        return new ResponseEntity<>(buildingService.getAllBuildings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBuildingById(@PathVariable Long id) {
        System.out.println("ici");
        return new ResponseEntity<>(buildingService.getBuildingById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBuilding(@RequestBody Building building) {
        System.out.println("ici");
        Building building1 = buildingService.saveBuilding(building);
        System.out.println(building1);
        if(building1 != null){
            return new ResponseEntity<>(building1, HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("Created failed", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public Building updateBuilding(@PathVariable Long id, @RequestBody Building building) {
        return buildingService.updateBuilding(id, building);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
    }
}
