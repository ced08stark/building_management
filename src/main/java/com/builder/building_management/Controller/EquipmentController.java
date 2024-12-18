package com.builder.building_management.Controller;

import com.builder.building_management.Model.Equipment;
import com.builder.building_management.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        List<Equipment> equipments = equipmentService.getAllEquipments();
        return ResponseEntity.ok(equipments); // Renvoie 200 OK avec la liste
    }

    @GetMapping("/buildings/{buildingId}")
    public ResponseEntity<?> getEquipmentsByBuildingId(@PathVariable Long buildingId) {
        List<Equipment> equipments = equipmentService.getEquipmentsByBuildingId(buildingId);

        if (equipments.isEmpty()) {
            return new ResponseEntity<>("No equipments found for this building.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long id) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        if (equipment != null) {
            return ResponseEntity.ok(equipment); // Renvoie 200 OK avec l'équipement trouvé
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si l'équipement est introuvable
    }

    @PostMapping
    public ResponseEntity<?> createEquipment(@RequestBody Equipment equipment, @RequestParam Long buildingId) {
        System.out.println(buildingId);
        Equipment savedEquipment = equipmentService.saveEquipment(equipment, buildingId);

        //return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipment); // Renvoie 201 Created avec l'équipement créé
        if(savedEquipment != null){
            return new ResponseEntity<>(savedEquipment, HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("Created failed", HttpStatus.BAD_REQUEST);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody Equipment equipment) {
        Equipment updatedEquipment = equipmentService.updateEquipment(id, equipment);
        if (updatedEquipment != null) {
            return ResponseEntity.ok(updatedEquipment); // Renvoie 200 OK avec l'équipement mis à jour
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si l'équipement est introuvable
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build(); // Renvoie 204 No Content
    }
}
