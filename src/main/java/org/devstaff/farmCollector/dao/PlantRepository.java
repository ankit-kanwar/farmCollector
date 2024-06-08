package org.devstaff.farmCollector.dao;

import org.devstaff.farmCollector.dao.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
