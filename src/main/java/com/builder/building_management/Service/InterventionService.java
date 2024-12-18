package com.builder.building_management.Service;

import com.builder.building_management.Model.Intervention;
import com.builder.building_management.Repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionService {
    @Autowired
    private InterventionRepository interventionRepository;

    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    public Intervention getInterventionById(Long id) {
        return interventionRepository.findById(id).orElse(null);
    }

    public Intervention saveIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    public Intervention updateIntervention(Long id, Intervention updatedIntervention) {
        Intervention intervention = getInterventionById(id);
        if (intervention != null) {
            intervention.setDescription(updatedIntervention.getDescription());
            intervention.setPlannedDate(updatedIntervention.getPlannedDate());
            return interventionRepository.save(intervention);
        }
        return null;
    }

    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }
}

