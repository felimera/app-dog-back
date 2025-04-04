package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_unidades_masa")
public class UnidadMasa {
    @Id
    @Column(name = "unm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "unm_nombre")
    private String nombre;
    @Column(name = "unm_descripcion")
    private String descripcion;
    @Column(name = "unm_sigla")
    private String sigla;
    @Column(name = "unm_valido")
    private Boolean valido;
}
