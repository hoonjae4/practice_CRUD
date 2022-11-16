package com.pet.pet.repository;

import com.pet.pet.model.Board;
import com.pet.pet.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    Report findById(int id);
}
