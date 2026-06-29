package com.tnp.placement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String company;

    private String email;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<PlacementDrive> placementDrives;

    public Recruiter() {}
    public Recruiter(String name, String company, String email) {
        this.name = name;
        this.company = company;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<PlacementDrive> getPlacementDrives() { return placementDrives; }
    public void setPlacementDrives(List<PlacementDrive> placementDrives) { this.placementDrives = placementDrives; }
}
