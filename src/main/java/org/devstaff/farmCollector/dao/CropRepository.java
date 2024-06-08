package org.devstaff.farmCollector.dao;

import org.devstaff.farmCollector.dao.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
