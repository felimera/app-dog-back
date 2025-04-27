package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MascotaDto {
    private Long idMascota;
    private String nombre;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private Long idRaza;
    private Long idColorPelo;
    private Long idCliente;
}
