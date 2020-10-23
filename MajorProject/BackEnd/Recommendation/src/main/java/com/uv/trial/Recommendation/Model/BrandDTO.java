package com.uv.trial.Recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
public class BrandDTO
{
    @Id
    @Column(name = "brandid")
    private int brandId;
    @Column(name = "brandname")
    private String brandName;
    @Column(name = "enable")
    private int enable;
}
