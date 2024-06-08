package org.devstaff.farmCollector.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.devstaff.farmCollector.dao.entity.Plant;
import org.devstaff.farmCollector.model.PlantDTO;
import org.devstaff.farmCollector.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/plant")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Plant API",
                version = "1.0",
                description = "API for managing planting"
        )
)
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping
    @Operation(summary = "Save a plantation", description = "Endpoint to save a new plantation with farm,crop, season" +
            ",planting area and expected product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plantation saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    public Plant savePlanting(@RequestBody PlantDTO plantDTO) {
        return plantService.savePlant(plantDTO);
    }

    @GetMapping
    @Operation(summary = "Get all plantations", description = "Endpoint to retrieve all plantations")
    public List<Plant> getAllPlantings() {
        return plantService.getAllPlants();
    }
}
