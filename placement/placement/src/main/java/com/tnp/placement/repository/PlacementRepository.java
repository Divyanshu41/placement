package com.tnp.placement.repository;

import com.tnp.placement.model.PlacementDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<PlacementDrive, Long> {
    // JpaRepository already provides save, findAll, findById, deleteById methods
}
