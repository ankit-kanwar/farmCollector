package org.devstaff.farmCollector.controller;

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
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping
    public Plant savePlanting(@RequestBody PlantDTO plantDTO) {
        return plantService.savePlant(plantDTO);
    }

    @GetMapping
    public List<Plant> getAllPlantings() {
        return plantService.getAllPlants();
    }
}
