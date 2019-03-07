package pl.coderslab.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sugar_level")
public class Glucometer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valSugar;
    private String dates;
    private String time;
    private double max = 99;
    private double min = 70;
}
