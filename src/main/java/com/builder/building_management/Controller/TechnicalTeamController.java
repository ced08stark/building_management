package com.builder.building_management.Controller;

import com.builder.building_management.Model.TechnicalTeam;
import com.builder.building_management.Service.TechnicalTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TechnicalTeamController {

    @Autowired
    private TechnicalTeamService teamService;

    @GetMapping
    public ResponseEntity<List<TechnicalTeam>> getAllTeams() {
        List<TechnicalTeam> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams); // Renvoie 200 OK avec la liste des équipes
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicalTeam> getTeamById(@PathVariable Long id) {
        TechnicalTeam team = teamService.getTeamById(id);
        if (team != null) {
            return ResponseEntity.ok(team); // Renvoie 200 OK avec l'équipe trouvée
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si introuvable
    }

    @PostMapping
    public ResponseEntity<TechnicalTeam> createTeam(@RequestBody TechnicalTeam team) {
        TechnicalTeam savedTeam = teamService.saveTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam); // Renvoie 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicalTeam> updateTeam(@PathVariable Long id, @RequestBody TechnicalTeam team) {
        TechnicalTeam updatedTeam = teamService.updateTeam(id, team);
        if (updatedTeam != null) {
            return ResponseEntity.ok(updatedTeam); // Renvoie 200 OK avec l'équipe mise à jour
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Renvoie 404 si introuvable
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build(); // Renvoie 204 No Content
    }
}
