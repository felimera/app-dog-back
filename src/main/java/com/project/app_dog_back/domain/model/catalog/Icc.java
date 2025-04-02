package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_icc")
public class Icc {
    @Id
    @Column(name = "icc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "icc_nombre")
    private String nombre;
    @Column(name = "icc_descripcion")
    private String descripcion;
    @Column(name = "icc_valido")
    private Boolean valido;
}
