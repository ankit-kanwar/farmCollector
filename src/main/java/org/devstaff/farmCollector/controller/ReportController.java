package org.devstaff.farmCollector.controller;

import org.devstaff.farmCollector.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public String getReports(Model model) {
        List<Map<String, Object>> reports = reportService.generateReportsBySeasons();
        model.addAttribute("reports", reports);
        return "reports";
    }
}

