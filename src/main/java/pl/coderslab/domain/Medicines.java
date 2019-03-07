package pl.coderslab.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medicines")
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medName;
    private String medDescription;
}
