package org.devstaff.farmCollector.dao;

import org.devstaff.farmCollector.dao.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {

}