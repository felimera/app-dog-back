package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class DosisMedicamentoDto {
    private Long idDosisMedicamento;
    private LocalDateTime fecha;
    private Boolean dosisSuministrada;
    private Long idMedicamento;
}
