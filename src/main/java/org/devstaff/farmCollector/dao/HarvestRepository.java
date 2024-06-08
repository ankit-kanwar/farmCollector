package org.devstaff.farmCollector.dao;

import org.devstaff.farmCollector.dao.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {

}