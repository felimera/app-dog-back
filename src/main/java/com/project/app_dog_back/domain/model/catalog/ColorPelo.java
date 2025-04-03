package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_colores_pelo")
public class ColorPelo {
    @Id
    @Column(name = "cop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cop_nombre")
    private String nombre;
    @Column(name = "cop_descripcion")
    private String descripcion;
    @Column(name = "cop_valido")
    private Boolean valido;
}
