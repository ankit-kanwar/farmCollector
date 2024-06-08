package org.devstaff.farmCollector.service;

import org.devstaff.farmCollector.dao.CropRepository;
import org.devstaff.farmCollector.dao.FarmRepository;
import org.devstaff.farmCollector.dao.HarvestRepository;
import org.devstaff.farmCollector.dao.SeasonRepository;
import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.model.HarvestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestServiceImpl implements HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public Harvest saveHarvest(HarvestDTO harvestDTO) {
        Harvest harvest = new Harvest();
        harvest.setFarm(farmRepository.findById(harvestDTO.getFarmId()).orElse(null));
        harvest.setCrop(cropRepository.findById(harvestDTO.getCropId()).orElse(null));
        harvest.setSeason(seasonRepository.findById(harvestDTO.getSeasonId()).orElse(null));;
        harvest.setActualProduct(harvestDTO.getActualProduct());
        return harvestRepository.save(harvest);
    }

    public List<Harvest> getAllHarvest() {
        return harvestRepository.findAll();
    }
}
