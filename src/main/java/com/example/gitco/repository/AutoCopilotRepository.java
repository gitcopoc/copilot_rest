package com.example.gitco.repository;

import com.example.gitco.model.AutoCopilot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoCopilotRepository extends JpaRepository<AutoCopilot, Long> {

    Optional<AutoCopilot> findById(Long aLong);
}