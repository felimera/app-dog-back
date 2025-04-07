package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MedicamentoDto {
    private Long idMedicamento;
    private String nombre;
    private String descripcion;
    private String famaceutica;
    private Long idViaAdministracion;
    private Boolean recetamedica;
    private LocalDateTime fechaRegistro;
}
