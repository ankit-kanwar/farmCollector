package org.devstaff.farmCollector.service;

import org.devstaff.farmCollector.dao.CropRepository;
import org.devstaff.farmCollector.dao.FarmRepository;
import org.devstaff.farmCollector.dao.PlantRepository;
import org.devstaff.farmCollector.dao.SeasonRepository;
import org.devstaff.farmCollector.dao.Seasons;
import org.devstaff.farmCollector.dao.entity.Crop;
import org.devstaff.farmCollector.dao.entity.Farm;
import org.devstaff.farmCollector.dao.entity.Plant;
import org.devstaff.farmCollector.dao.entity.Season;
import org.devstaff.farmCollector.model.PlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public Plant savePlant(PlantDTO plantingDTO) {
        Farm farm = farmRepository.findById(plantingDTO.getFarmId()).orElse(null);
        if (farm == null) {
            farm = new Farm();
            farm.setId(plantingDTO.getFarmId());
            farm.setName(plantingDTO.getFarmName());
            farm = farmRepository.save(farm);
        }

        Crop crop = cropRepository.findById(plantingDTO.getCropId()).orElse(null);
        if (crop == null) {
            crop = new Crop();
            crop.setId(plantingDTO.getCropId());
            crop.setType(plantingDTO.getCropType());
            crop = cropRepository.save(crop);
        }

        Season season = seasonRepository.findById(plantingDTO.getSeasonId()).orElse(null);
        if (season == null) {
            season = new Season();
            season.setSeason(Seasons.valueOf(plantingDTO.getSeasonName()));
            season = seasonRepository.save(season);
        }

            Plant planting = new Plant();
            planting.setFarm(farm);
            planting.setCrop(crop);
            planting.setSeason(season);
            planting.setPlantingArea(plantingDTO.getPlantingArea());
            planting.setExpectedProduct(plantingDTO.getExpectedProduct());
            return plantRepository.save(planting);

    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
}
