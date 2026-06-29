package com.tnp.placement.service;

import com.tnp.placement.model.PlacementDrive;
import com.tnp.placement.repository.PlacementRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    private final PlacementRepository placementRepository;

    public PlacementService(PlacementRepository placementRepository) {
        this.placementRepository = placementRepository;
    }

    public PlacementDrive addPlacementDrive(PlacementDrive drive) {
        return placementRepository.save(drive);
    }

    public List<PlacementDrive> getAllPlacementDrives() {
        return placementRepository.findAll();
    }

    public Optional<PlacementDrive> getPlacementById(Long id) {
        return placementRepository.findById(id);
    }

    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}
