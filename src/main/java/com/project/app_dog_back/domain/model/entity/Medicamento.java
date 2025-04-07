package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.catalog.ViaAdministracion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private Long id;
    @Column(name = "med_nombre", unique = true, nullable = false, columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "med_descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "med_farmaceutica", columnDefinition = "TEXT")
    private String famaceutica;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "med_via_administracion_id")
    private ViaAdministracion viaAdministracion;
    @Column(name = "med_receta_medica")
    private Boolean recetamedica;
    @Column(name = "med_fecha_registro")
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }
}
