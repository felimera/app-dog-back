package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_tipo_alimento")
public class TipoAlimento {
    @Id
    @Column(name = "tia_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tia_nombre")
    private String nombre;
    @Column(name = "tia_descripcion")
    private String descripcion;
    @Column(name = "tia_valido")
    private Boolean valido;
}
