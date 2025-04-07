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
@Table(name = "tbl_dosis_medicamento")
public class DosisMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dos_id")
    private Long id;
    @Column(name = "dos_fecha")
    private LocalDateTime fecha;
    @Column(name = "dos_dosis_suministrada")
    private Boolean dosisSuministrada;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dos_medicamento_id")
    private Medicamento medicamento;
}
