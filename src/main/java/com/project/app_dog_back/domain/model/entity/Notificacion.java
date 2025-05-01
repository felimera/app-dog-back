package com.project.app_dog_back.domain.model.entity;

import com.project.app_dog_back.domain.model.component.TipoNotificacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "not_tipo")
    private TipoNotificacion tipoNotificacion;
    @Column(name = "not_fecha")
    private LocalDateTime fecha;
    @Column(name = "not_notificacion_validacion")
    private Boolean notificacionValidacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_sal_id")
    private Salida salida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_sum_id")
    private SuministroAlimento suministroAlimento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_dos_id")
    private DosisMedicamento dosisMedicamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_mas_id")
    private Mascota mascota;
}
