package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.catalog.Animo;
import com.project.app_dog_back.domain.model.catalog.Icc;
import com.project.app_dog_back.domain.model.catalog.Movilidad;
import com.project.app_dog_back.domain.model.catalog.UnidadMasa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_revision")
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    private Integer id;
    @Column(name = "rev_peso", precision = 5, scale = 2)
    private BigDecimal peso;
    @Column(name = "rev_canas")
    private Boolean canas;
    @Column(name = "rev_problemas_vision")
    private Boolean problemasVision;
    @Column(name = "rev_problemas_respirar")
    private Boolean problemasRespirar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rev_mascota_id")
    private Mascota mascota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rev_icc_id")
    private Icc icc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rev_movilidad_id")
    private Movilidad movilidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rev_animo_id")
    private Animo animo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rev_unidadmasa_id")
    private UnidadMasa unidadMasa;

    @Column(name = "rev_fecha_registro")
    private LocalDateTime fechaRegistro;
}
