package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PerroDto {
    private Integer idPerro;
    private String nombre;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private BigDecimal peso;
    private Boolean canas;
    private Boolean problemasVision;
    private Boolean problemasRespirar;

    private Long idRaza;
    private Long idIcc;
    private Long idMovilidad;
    private Long idColorPelo;
    private Long idAnimo;
    private Long idUnidadMasa;
}
