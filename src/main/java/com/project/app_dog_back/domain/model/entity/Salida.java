package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.component.TipoSalida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_salida")
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sal_id")
    private Integer id;
    @Column(name = "sal_fecha")
    private LocalDateTime fechaHora;
    @Column(name = "sal_salida_realizada")
    private Boolean salidaRealizada;
    @Enumerated(EnumType.STRING)
    @Column(name = "sal_tipo_salida", nullable = false)
    private TipoSalida tipoSalida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sal_mascota_id")
    private Mascota mascota;
}
