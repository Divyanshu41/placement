package com.tnp.placement.repository;

import com.tnp.placement.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    // JpaRepository already provides save, findAll, findById, deleteById methods
}
