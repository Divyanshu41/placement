package com.tnp.placement.controller;

import com.tnp.placement.model.Recruiter;
import com.tnp.placement.service.RecruiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/add")
    public Recruiter addRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.addRecruiter(recruiter);
    }

    @GetMapping("/all")
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) {
        return recruiterService.getRecruiterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
    }
}
