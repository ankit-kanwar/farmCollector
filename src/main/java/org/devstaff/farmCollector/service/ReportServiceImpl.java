package org.devstaff.farmCollector.service;

import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.dao.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private PlantService plantService;

    @Autowired
    private HarvestServiceImpl harvestService;
    @Override
    public List<Map<String, Object>> generateReportsBySeasons() {
        List<Plant> plantings = plantService.getAllPlants();
        List<Harvest> harvestings = harvestService.getAllHarvest();

        Map<String, List<Harvest>> harvestsBySeason = new HashMap<>();

        // Grouping harvestings by season
        for (Harvest harvest : harvestings) {
            String season = harvest.getSeason().getSeason().name();
            harvestsBySeason.putIfAbsent(season, new ArrayList<>());
            harvestsBySeason.get(season).add(harvest);
        }

        List<Map<String, Object>> reports = new ArrayList<>();

        // Iterating over each season and generate reports
        harvestsBySeason.forEach((season, harvests) -> {
            Map<String, Map<String, Double>> farmCropReport = new HashMap<>();

            // Generating report for each harvest
            for (Harvest harvest : harvests) {
                String farmName = harvest.getFarm().getName();
                String cropType = harvest.getCrop().getType();
                double actualProduct = harvest.getActualProduct();

                farmCropReport.putIfAbsent(farmName, new HashMap<>());
                Map<String, Double> cropReport = farmCropReport.get(farmName);
                cropReport.put(cropType, cropReport.getOrDefault(cropType, 0.0) + actualProduct);
            }

            farmCropReport.forEach((farmName, cropReport) -> {
                cropReport.forEach((cropType, actualProduct) -> {
                    Plant plant = getPlantByFarmAndCrop(plantings, farmName, cropType);
                    double expectedProduct = (plant != null) ? plant.getExpectedProduct() : 0.0;

                    Map<String, Object> report = new HashMap<>();
                    report.put("season", season);
                    report.put("farmName", farmName);
                    report.put("cropType", cropType);
                    report.put("expectedProduct", expectedProduct);
                    report.put("actualProduct", actualProduct);
                    reports.add(report);
                });
            });
        });

        return reports;
    }

    private Plant getPlantByFarmAndCrop(List<Plant> plantings, String farmName, String cropType) {
        for (Plant plant : plantings) {
            if (plant.getFarm().getName().equals(farmName) && plant.getCrop().getType().equals(cropType)) {
                return plant;
            }
        }
        return null;
    }
}
