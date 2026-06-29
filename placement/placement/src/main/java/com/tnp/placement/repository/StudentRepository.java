package com.tnp.placement.repository;

import com.tnp.placement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // JpaRepository already provides save, findAll, findById, deleteById methods
}
