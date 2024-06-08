package org.devstaff.farmCollector.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.model.HarvestDTO;
import org.devstaff.farmCollector.service.HarvestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/harvest")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Harvest API",
                version = "1.0",
                description = "API for managing harvesting"
        )
)
public class HarvestController {
    @Autowired
    private HarvestServiceImpl harvestService;

    @PostMapping
    @Operation(summary = "Save a harvest", description = "Endpoint to save a new harvest with farm,crop and season and actual product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Planting saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    public Harvest saveHarvest(@RequestBody HarvestDTO harvestDTO) {
        return harvestService.saveHarvest(harvestDTO);
    }

    @GetMapping
    @Operation(summary = "Get all harvests", description = "Endpoint to retrieve all harvests")
    public List<Harvest> getAllHarvests() {
        return harvestService.getAllHarvest();
    }
}
