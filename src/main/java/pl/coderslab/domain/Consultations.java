package pl.coderslab.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "consultations")
public class Consultations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 5)
    private String name;
    private String description;
    private String date;
}
