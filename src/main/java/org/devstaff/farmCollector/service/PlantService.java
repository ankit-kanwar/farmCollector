package org.devstaff.farmCollector.service;

import org.devstaff.farmCollector.dao.entity.Plant;
import org.devstaff.farmCollector.model.PlantDTO;

import java.util.List;

public interface PlantService {

    Plant savePlant(PlantDTO plantingDTO);

    List<Plant> getAllPlants();
}
