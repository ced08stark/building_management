package com.builder.building_management.Service;

import com.builder.building_management.Model.TechnicalTeam;
import com.builder.building_management.Repository.TechnicalTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalTeamService {
    @Autowired
    private TechnicalTeamRepository teamRepository;

    public List<TechnicalTeam> getAllTeams() {
        return teamRepository.findAll();
    }

    public TechnicalTeam getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public TechnicalTeam saveTeam(TechnicalTeam team) {
        return teamRepository.save(team);
    }

    public TechnicalTeam updateTeam(Long id, TechnicalTeam updatedTeam) {
        TechnicalTeam team = getTeamById(id);
        if (team != null) {
            team.setName(updatedTeam.getName());
            team.setExpertise(updatedTeam.getExpertise());
            return teamRepository.save(team);
        }
        return null;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}

