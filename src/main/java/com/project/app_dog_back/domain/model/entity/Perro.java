package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.catalog.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_perro")
public class Perro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Integer id;
    @Column(name = "per_nombre", nullable = false, columnDefinition = "TEXT")
    private String nombre;
    @Column(name = "per_edad")
    private Integer edad;
    @Column(name = "per_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "per_peso", precision = 5, scale = 2)
    private BigDecimal peso;
    @Column(name = "per_canas")
    private Boolean canas;
    @Column(name = "per_problemas_vision")
    private Boolean problemasVision;
    @Column(name = "per_problemas_respirar")
    private Boolean problemasRespirar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_raza_id")
    private Raza raza;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_icc_id")
    private Icc icc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_movilidad_id")
    private Movilidad movilidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_color_pelo_id")
    private ColorPelo colorPelo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_animo_id")
    private Animo animo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_unidadmasa_id")
    private UnidadMasa unidadMasa;
}
