package com.tnp.placement.service;

import com.tnp.placement.model.Recruiter;
import com.tnp.placement.repository.RecruiterRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public Recruiter addRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    public Optional<Recruiter> getRecruiterById(Long id) {
        return recruiterRepository.findById(id);
    }

    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }
}
