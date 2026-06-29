package com.tnp.placement.model;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // Applied, Selected, Rejected

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "placement_drive_id")
    private PlacementDrive placementDrive;

    public Application() {}
    public Application(String status, Student student, PlacementDrive placementDrive) {
        this.status = status;
        this.student = student;
        this.placementDrive = placementDrive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public PlacementDrive getPlacementDrive() { return placementDrive; }
    public void setPlacementDrive(PlacementDrive placementDrive) { this.placementDrive = placementDrive; }
}
