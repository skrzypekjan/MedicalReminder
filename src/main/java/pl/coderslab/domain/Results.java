package pl.coderslab.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double value;
    private String date;
    @ManyToOne
    private Values val;
    @ManyToOne
    private Unit unt;
}
