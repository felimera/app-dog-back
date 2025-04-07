package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_via_administracion")
public class ViaAdministracion {
    @Id
    @Column(name = "vad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vad_nombre")
    private String nombre;
    @Column(name = "vad_descripcion")
    private String descripcion;
    @Column(name = "vad_valido")
    private Boolean valido;
}
