package org.devstaff.farmCollector.controller;

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
public class HarvestController {
    @Autowired
    private HarvestServiceImpl harvestService;

    @PostMapping
    public Harvest saveHarvest(@RequestBody HarvestDTO harvestDTO) {
        return harvestService.saveHarvest(harvestDTO);
    }

    @GetMapping
    public List<Harvest> getAllHarvests() {
        return harvestService.getAllHarvest();
    }
}
