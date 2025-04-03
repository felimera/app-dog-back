package com.project.app_dog_back.domain.model.catalog;

import com.project.app_dog_back.domain.model.component.Tamano;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_razas_perro")
public class Raza {
    @Id
    @Column(name = "rap_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rap_nombre")
    private String nombre;
    @Column(name = "rap_descripcion")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "rap_tamano", nullable = false)
    private Tamano tamano;
    @Column(name = "rap_valido")
    private Boolean valido;
}
