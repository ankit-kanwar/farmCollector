package org.devstaff.farmCollector.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> generateReportsBySeasons();
}
