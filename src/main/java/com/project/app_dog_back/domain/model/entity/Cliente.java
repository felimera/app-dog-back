package com.project.app_dog_back.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Integer id;
    @Column(name = "cli_nombre", nullable = false, columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "cli_apellido", columnDefinition = "TEXT")
    private String apellido;
    @Column(name = "cli_email", unique = true, columnDefinition = "TEXT")
    private String email;
    @Column(name = "cli_telefono")
    private String telefono;
    @Column(name = "cli_direccion")
    private String direccion;
    @Column(name = "cli_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "cli_fecha_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;
    @Column(name = "cli_activo")
    private Boolean activo;

    @PrePersist
    public void prePersist() {
        if (this.activo == null) {
            this.activo = true;
        }
    }
}
