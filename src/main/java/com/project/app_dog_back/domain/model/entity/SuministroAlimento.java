package com.project.app_dog_back.domain.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_suminstro_alimento")
public class SuministroAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sum_id")
    private Long id;
    @Column(name = "sum_fecha")
    private LocalDateTime fecha;
    @Column(name = "sum_suministro_dado")
    private Boolean suministroDado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sum_alimento_id")
    private Alimento alimento;
}
