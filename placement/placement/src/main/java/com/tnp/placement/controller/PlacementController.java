package com.tnp.placement.controller;

import com.tnp.placement.model.PlacementDrive;
import com.tnp.placement.service.PlacementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    private final PlacementService placementService;

    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    @PostMapping("/add")
    public PlacementDrive addPlacementDrive(@RequestBody PlacementDrive drive) {
        return placementService.addPlacementDrive(drive);
    }

    @GetMapping("/all")
    public List<PlacementDrive> getAllPlacementDrives() {
        return placementService.getAllPlacementDrives();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlacementDrive> getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }
}
