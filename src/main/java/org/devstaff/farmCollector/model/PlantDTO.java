package org.devstaff.farmCollector.model;

import lombok.Data;

@Data
public class PlantDTO {
    private Long farmId;
    private String farmName;  // can be null if farm already exists
    private Long cropId;
    private String cropType; // can be null if crop type already exists
    private Long seasonId;
    private String seasonName;
    private double plantingArea;
    private double expectedProduct;
}
