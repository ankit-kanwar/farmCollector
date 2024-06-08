package org.devstaff.farmCollector.dao;

import org.devstaff.farmCollector.dao.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
