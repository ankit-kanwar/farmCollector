package org.devstaff.farmCollector.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@OpenAPIDefinition(info = @Info(title = "Reports API",
                                version = "1.0",
                                description = "API endpoints for retrieving reports"))

public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    @Operation(summary = "Get Reports", description = "Endpoint to retrieve reports")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved reports"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String getReports(Model model) {
        List<Map<String, Object>> reports = reportService.generateReportsBySeasons();
        model.addAttribute("reports", reports);
        return "reports";
    }
}

