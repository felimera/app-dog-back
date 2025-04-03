package com.project.app_dog_back.domain.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cat_animo")
public class Animo {
    @Id
    @Column(name = "ani_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ani_nombre")
    private String nombre;
    @Column(name = "ani_descripcion")
    private String descripcion;
    @Column(name = "ani_valido")
    private Boolean valido;
}
