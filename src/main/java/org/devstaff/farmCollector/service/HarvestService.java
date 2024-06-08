package org.devstaff.farmCollector.service;

import org.devstaff.farmCollector.dao.entity.Harvest;
import org.devstaff.farmCollector.model.HarvestDTO;

import java.util.List;

public interface HarvestService {

    Harvest saveHarvest(HarvestDTO harvestDTO);

    List<Harvest> getAllHarvest();
}
