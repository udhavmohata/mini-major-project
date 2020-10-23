package com.uv.trial.Recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "category")
public class CategoryDTO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private int categoryId;
    @Column(name = "categoryname")
    private String CategoryName;
}
