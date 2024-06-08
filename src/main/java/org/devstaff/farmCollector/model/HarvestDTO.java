package org.devstaff.farmCollector.model;

import lombok.Data;

@Data
public class HarvestDTO {
    private Long farmId; // here we do not need to worry about farm and crop as only planted crop can be harvested
    private Long cropId;
    private Long seasonId;
    private double actualProduct;
}
