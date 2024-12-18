package com.builder.building_management.Repository;


import com.builder.building_management.Model.TechnicalTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalTeamRepository extends JpaRepository<TechnicalTeam, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
}