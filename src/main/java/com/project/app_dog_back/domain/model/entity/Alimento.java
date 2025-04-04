package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.catalog.TipoAlimento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ali_id")
    private Long id;
    @Column(name = "ali_nombre", nullable = false, columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "ali_descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ali_tipoalimento_id")
    private TipoAlimento tipoAlimento;
}
