package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_movilidad")
public class Movilidad {
    @Id
    @Column(name = "mov_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mov_nombre")
    private String nombre;
    @Column(name = "mov_descripcion")
    private String descripcion;
    @Column(name = "mov_valido")
    private Boolean valido;
}
