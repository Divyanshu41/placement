package com.tnp.placement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PlacementDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String role;

    private double cgpaCriteria;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    @OneToMany(mappedBy = "placementDrive", cascade = CascadeType.ALL)
    private List<Application> applications;

    public PlacementDrive() {}
    public PlacementDrive(String companyName, String role, double cgpaCriteria, Recruiter recruiter) {
        this.companyName = companyName;
        this.role = role;
        this.cgpaCriteria = cgpaCriteria;
        this.recruiter = recruiter;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getCgpaCriteria() { return cgpaCriteria; }
    public void setCgpaCriteria(double cgpaCriteria) { this.cgpaCriteria = cgpaCriteria; }

    public Recruiter getRecruiter() { return recruiter; }
    public void setRecruiter(Recruiter recruiter) { this.recruiter = recruiter; }

    public List<Application> getApplications() { return applications; }
    public void setApplications(List<Application> applications) { this.applications = applications; }
}
