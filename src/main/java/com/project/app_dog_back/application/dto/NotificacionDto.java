package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificacionDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idNotificacion;
    @Schema(description = "Notification type. Example: C => birthday, A => food, B => bath, M => medicine.", example = "C")
    @NotEmpty(message = "The notificaction cannot be empty.")
    @NotNull(message = "The notificaction cannot be null.")
    private String tipoNotificacion;
    @Schema(description = "Date and hour of registration of the notificaction.", example = "2025-04-07T20:59:23.282Z")
    private String fecha;
    @Schema(description = "Validation if the notification is valid or invalid. Ex: True o False", example = "true")
    @NotNull(message = "Validation cannot be null.")
    private Boolean isNotificacionValidacion;

    @Schema(description = "Identificador de llave foreanea. (Salida)", example = "1")
    private Long idSalida;
    @Schema(description = "Identificador de llave foreanea. (Suministro de alimento)", example = "1")
    private Long idSuministroAlimento;
    @Schema(description = "Identificador de llave foreanea. (Dosis de medicamento)", example = "1")
    private Long idDosisMedicamento;
    @Schema(description = "Identificador de llave foreanea. (Mascotas)", example = "1")
    private Long idMascota;
}
