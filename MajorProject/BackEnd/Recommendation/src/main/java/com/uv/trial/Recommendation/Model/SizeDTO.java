package com.uv.trial.Recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "size")
public class SizeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sizeid")
    private int sizeId;
    @Column(name = "categoryid")
    private int categoryId;
    @Column(name = "brandid")
    private int brandId;
    @Column(name = "maleheight")
    private int maleHeight;
    @Column(name = "malechest")
    private int maleChest;
    @Column(name = "malesleeves")
    private int maleSleeves;
    @Column(name = "malewaistcm")
    private int maleWaist;
    @Column(name = "maleshoescm")
    private int maleShoeSize;
    @Column(name = "femaleheight")
    private int femaleHeight;
    @Column(name = "femalechest")
    private int femaleChest;
    @Column(name = "femalesleeves")
    private int femaleSleeves;
    @Column(name = "femalewaistcm")
    private int femaleWaist;
    @Column(name = "femaleshoescm")
    private int femaleShoeSize;
    @Column(name = "size")
    private String Size;
}

