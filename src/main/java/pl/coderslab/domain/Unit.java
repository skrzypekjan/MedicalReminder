package pl.coderslab.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "unit_values")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String unitName;
}
