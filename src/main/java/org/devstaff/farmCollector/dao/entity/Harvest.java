package org.devstaff.farmCollector.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "HARVEST")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FARM_ID", nullable = false)
    private Farm farm;

    @ManyToOne
    @JoinColumn(name = "CROP_ID", nullable = false)
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "SEASON_ID", nullable =false)
    private Season season;

    @Column(name = "ACTUAL_PRODUCT")
    private double actualProduct;

}
