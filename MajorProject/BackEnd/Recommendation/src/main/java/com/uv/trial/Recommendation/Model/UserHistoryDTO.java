package com.uv.trial.Recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "userhistory")
public class UserHistoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    @Column(name = "userid")
    public int userId;
    @Column(name = "categoryid")
    private int categoryId;
    @Column(name = "sizeid")
    private int sizeId;
}
