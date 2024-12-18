package com.builder.building_management.Controller;

import com.builder.building_management.Model.Intervention;
import com.builder.building_management.Service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
    @Autowired
    private InterventionService interventionService;

    @GetMapping
    public ResponseEntity<List<Intervention>> getAllInterventions() {
        List<Intervention> interventions = interventionService.getAllInterventions();
        return ResponseEntity.ok(interventions); // Renvoie 200 OK avec la liste des interventions
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        Intervention intervention = interventionService.getInterventionById(id);
        if (intervention != null) {
            return ResponseEntity.ok(intervention); // Renvoie 200 OK avec l'intervention trouvée
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si introuvable
    }

    @PostMapping
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        Intervention savedIntervention = interventionService.saveIntervention(intervention);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIntervention); // Renvoie 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention intervention) {
        Intervention updatedIntervention = interventionService.updateIntervention(id, intervention);
        if (updatedIntervention != null) {
            return ResponseEntity.ok(updatedIntervention); // Renvoie 200 OK avec l'intervention mise à jour
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si introuvable
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        interventionService.deleteIntervention(id);
        return ResponseEntity.noContent().build(); // Renvoie 204 No Content
    }
}
