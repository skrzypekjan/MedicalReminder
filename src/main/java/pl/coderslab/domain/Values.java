package pl.coderslab.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test_values")
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typ;
    private double max;
    private double min;
}
