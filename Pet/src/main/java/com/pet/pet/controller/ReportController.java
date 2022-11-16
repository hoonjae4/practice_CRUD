package com.pet.pet.controller;

import com.pet.pet.model.Board;
import com.pet.pet.model.Report;
import com.pet.pet.repository.BoardRepository;
import com.pet.pet.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/report")
    public String report(Model model) {
        List<Report> report = reportRepository.findAll();
        model.addAttribute("report",report);
        return "report";
    }

}
